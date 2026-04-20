#include "Header.h"
#include <iostream>
//FIX_ME: использование using namespace std запрещено Google Style Guide
//using namespace std;
//Далее во всем коде будут прописанны std::

//FIX_ME: переименованы параметры и поля по Google Style
//FIX_ME: используем актуальные имена переменных и полей 
Node::Node(int v) : value(v), prev(nullptr), next(nullptr) {}
DoublyList::DoublyList() : head(nullptr) {}

//FIX_ME: добавлен деструктора — память очищалась только вручную
DoublyList::~DoublyList() {
    clear();
}

// Добавление элемента в конец списка
void DoublyList::add(int value) {
    //FIX_ME: старый код создавал Uzel вручную, без конструктора
    /*
    void DobavitElement(int Znachenie) {
        Uzel* Noviy = new Uzel;
        Noviy->Znachenie = Znachenie;
        Noviy->Predydushiy = nullptr;
        Noviy->Sleduyushiy = nullptr;
    
        if (PerviyElement == nullptr) {
            PerviyElement = Noviy;
        }
        else {
            Uzel* Tekushiy = PerviyElement;
            while (Tekushiy->Sleduyushiy != nullptr) {
                Tekushiy = Tekushiy->Sleduyushiy;
            }
            Tekushiy->Sleduyushiy = Noviy;
            Noviy->Predydushiy = Tekushiy;
        }
    }
    */
    Node* new_node = new Node(value);
    if (head == nullptr) {
        head = new_node;
        return;
    }

    Node* current_node = head;
    while (current_node->next != nullptr) {
        current_node = current_node->next;
    }

    current_node->next = new_node;
    new_node->prev = current_node;
}

// Удаление одного узла
void DoublyList::remove_node(Node* node) {
    //FIX_ME: раньше не было метода удаления — нарушение задания
    if (node == nullptr) return;

    if (node->prev != nullptr)
        node->prev->next = node->next;
    else
        head = node->next;

    if (node->next != nullptr)
        node->next->prev = node->prev;

    delete node;
}

// Очистка списка
void DoublyList::clear() {
    //FIX_ME: старый код использовал Uzel, теперь Node
    /*void Ochistka() {
        Uzel* Tekushiy = PerviyElement;
        while (Tekushiy != nullptr) {
            Uzel* Vremenniy = Tekushiy;
            Tekushiy = Tekushiy->Sleduyushiy;
            delete Vremenniy;
        }
        PerviyElement = nullptr;
    }
    */
    Node* current_node = head;

    while (current_node != nullptr) {
        Node* temp_node = current_node;
        current_node = current_node->next;
        delete temp_node;
    }

    head = nullptr;
}

// Вывод всех элементов списка
void DoublyList::print() {
    /*FIX_ME: старый код использовал Uzel и русские имена
    void VivodSpiska() {
        Uzel* Tekushiy = PerviyElement;
        while (Tekushiy != nullptr) {
            cout << Tekushiy->Znachenie << " ";
            Tekushiy = Tekushiy->Sleduyushiy;
        }
        cout << endl;
    }
    */
    Node* current_node = head;
    while (current_node != nullptr) {
        std::cout << current_node->value << " ";
        current_node = current_node->next;
    }
    std::cout << std::endl;
}


// Поиск минимального и максимального элементов
void DoublyList::find_min_max(Node*& min_node, Node*& max_node) {
    //FIX_ME: старый код работал с Uzel и PerviyElement
    /*void PoiskMinMax(Uzel*& Min, Uzel*& Max) {
        if (PerviyElement == nullptr) return;
    
        Min = Max = PerviyElement;
        Uzel* Tekushiy = PerviyElement->Sleduyushiy;
    
        while (Tekushiy != nullptr) {
            if (Tekushiy->Znachenie < Min->Znachenie) Min = Tekushiy;
            if (Tekushiy->Znachenie > Max->Znachenie) Max = Tekushiy;
            Tekushiy = Tekushiy->Sleduyushiy;
        }
    }*/
    if (head == nullptr) {
        min_node = max_node = nullptr;
        return;
    }

    min_node = max_node = head;
    Node* current_node = head->next;

    while (current_node != nullptr) {
        if (current_node->value < min_node->value) min_node = current_node;
        if (current_node->value > max_node->value) max_node = current_node;
        current_node = current_node->next;
    }
}


// Проверка, какой элемент встречается раньше
bool DoublyList::is_first(Node* a, Node* b) {
    //FIX_ME: старый код использовал Uzel и PerviyElement
    /*bool ProverkaPoryadka(Uzel* A, Uzel* B) {
        Uzel* Tekushiy = PerviyElement;
        while (Tekushiy != nullptr) {
            if (Tekushiy == A) return true;
            if (Tekushiy == B) return false;
            Tekushiy = Tekushiy->Sleduyushiy;
        }
        return false;
    }*/
    Node* current_node = head;
    while (current_node != nullptr) {
        if (current_node == a) return true;
        if (current_node == b) return false;
        current_node = current_node->next;
    }
    return false;
}


// Вывод элементов между минимальным и максимальным
void DoublyList::print_between_min_max() {
    //FIX_ME: логика сохранена, но переписана под Node и новые имена
    /*void VivodMezhduMinMax() {
        Uzel* Min = nullptr;
        Uzel* Max = nullptr;
        PoiskMinMax(Min, Max);
    
        if (Min == nullptr || Max == nullptr || Min == Max) {
            cout << "Нет элементов для вывода!" << endl;
            return;
        }
    
        bool MinPerviy = ProverkaPoryadka(Min, Max);
        Uzel* Start = MinPerviy ? Min : Max;
        Uzel* End = MinPerviy ? Max : Min;
    
        cout << "Элементы между " << Min->Znachenie << " и " << Max->Znachenie << ": ";
        Uzel* Tekushiy = Start->Sleduyushiy;
        bool EstElementy = false;
    
        while (Tekushiy != nullptr && Tekushiy != End) {
            cout << Tekushiy->Znachenie << " ";
            EstElementy = true;
            Tekushiy = Tekushiy->Sleduyushiy;
        }
    
        if (!EstElementy) cout << "Отсутствуют";
        cout << endl;
    }*/
    Node* min_node = nullptr;
    Node* max_node = nullptr;
    find_min_max(min_node, max_node);

    if (min_node == nullptr || max_node == nullptr || min_node == max_node) {
        std::cout << "Нет элементов для вывода!" << std::endl;
        return;
    }

    bool min_first = is_first(min_node, max_node);

    Node* start = min_first ? min_node : max_node;
    Node* end = min_first ? max_node : min_node;

    Node* current_node = start->next;
    bool found = false;

    std::cout << "Элементы между " << min_node->value
        << " и " << max_node->value << ": ";

    while (current_node != nullptr && current_node != end) {
        std::cout << current_node->value << " ";
        found = true;
        current_node = current_node->next;
    }

    if (!found) std::cout << "Отсутствуют";

    std::cout << std::endl;
}


// Дружественная функция
void print_between_min_max(DoublyList& list) {

    //FIX_ME: раньше дружественного интерфейса не было — нарушение задания
    //Spisok.VivodMezhduMinMax();
    list.print_between_min_max();
}