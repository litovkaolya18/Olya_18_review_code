#include <iostream>
#include <windows.h>
#include "Header1.h"

// создаёт узел со значением value
Node::Node(int value) : data(value), next(nullptr) {}

// создаёт пустой список
LinkedList::LinkedList() : head(nullptr) {}

// добавляет новый элемент в конец списка
void LinkedList::add(int value) {
    //FIX_ME: имя переменной нарушает стиль — CamelCase запрещён
    //Node* newNode = new Node(value);
    Node* new_node = new Node(value);
    if (head == nullptr) {
        head = new_node;
    }
    else {
        //FIX_ME: переменная current нарушает стиль
        //Node* current = head;
        Node* current_node = head;
        while (current_node->next != nullptr) {
            current_node = current_node->next;
        }
        current_node->next = new_node;
    }
}

//FIX_ME: Логика вставки неверная — вставлялось после первого элемента,
// а нужно перед каждым вторым элементом.Счётчик count использовался 
// неправильно: он считал пары, а не реальные позиции. Вставленный 
// узел учитывался в нумерации, что смещало позиции и ломало алгоритм.
//Не использовался указатель prev, поэтому невозможно было корректно вставлять
//    узел перед current (особенно перед головой списка)
/*
// Метод для вставки значения M перед каждым вторым элементом
void insertBeforeEverySecond(int M) {
    Node* current = head;
    int count = 1;                  // Счетчик для отслеживания позиции

    while (current != nullptr && current->next != nullptr) {
        if (count % 2 == 1) {       // Если текущий элемент — первый в паре
            Node* newNode = new Node(M); // Создаем новый узел со значением M
            newNode->next = current->next; // Новый узел указывает на следующий элемент
            current->next = newNode; // Текущий узел указывает на новый узел
            current = newNode->next; // Переходим к следующему элементу
        }
        else {
            current = current->next;
        }
        count++;
    }
}
*/
void LinkedList::insert_before_every_second(int m) {
    //FIX_ME: отсутствовала проверка на пустой список и список из одного элемента.
    //if (!head || !head->next) return; //меньше двух элементов
    if (head == nullptr || head->next == nullptr) {
        return;  // нечего вставлять
    }

    Node* current = head;
    Node* prev = nullptr;
    int index = 1; // реальная позиция элемента в списке

    while (current != nullptr) {
        if (index % 2 == 0) { // каждый второй элемент
            Node* new_node = new Node(m);
            new_node->next = current;

            if (prev == nullptr) {
                // вставка перед головой
                head = new_node;
            }
            else {
                // вставка между prev и current
                prev->next = new_node;
            }

            prev = new_node; // prev теперь указывает на вставленный M
        }

        prev = current;          // смещаем prev на текущий элемент
        current = current->next; // идём дальше
        index++;
    }
}

void LinkedList::print() {
    //FIX_ME: имя переменной нарушает стиль — надо lower_case_with_underscores
    //Node* current = head;           
    Node* current_node = head;   // Начинаем с головы списка
    while (current_node != nullptr) {    // Пока не дойдем до конца списка
        std::cout << current_node->data << " "; // Выводим данные текущего узла
        current_node = current_node->next;    // Переходим к следующему узлу
    }
    std::cout << std::endl;         // Переход на новую строку после вывода
}

// Метод для получения указателя на последний элемент списка
Node* LinkedList::get_last_node() {
    //FIX_ME: имя переменной нарушает стиль — надо lower_case_with_underscores
    //Node* current = head;           
    Node* current_node = head;  // Начинаем с головы списка
    // Идем до последнего узла
    while (current_node != nullptr && current_node->next != nullptr) {
        current_node = current_node->next;
    }
    return current_node; // Возвращаем указатель на последний узел
}

void LinkedList::clear_list() {
    //FIX_ME: добавлена проверка на пустой список
    if (head == nullptr) {
        std::cout << "Список уже пуст." << std::endl;
        return;
    }

    while (head != nullptr) {   // Пока список не пуст
        //FIX_ME: имя переменной нарушает стиль
       // Node* temp = head;         
        Node* temp_node = head; // Сохраняем текущую голову
        head = head->next;      // Перемещаем голову на следующий узел
        delete temp_node;            // Удаляем узел
    }
   std::cout << "Список очищен." << std::endl;
}

void insert_before_every_second(LinkedList& list, int m) {
    list.insert_before_every_second(m);
}
