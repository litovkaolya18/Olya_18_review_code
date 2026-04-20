#include "Header.h"
#include <iostream>
//FIX_ME: использование using namespace std запрещено Google Style Guide
//using namespace std;
//Далее во всем коде будут прописанны std::

//FIX_ME: переименованы параметры и поля по Google Style
//FIX_ME: используем актуальные имена переменных и полей 
Queue::Queue() : p1_(nullptr), p2_(nullptr) {}

void Queue::push(int value) { // Добавление элемента в очередь
    //Node* newNode = new Node;
    //newNode->data = num;
    // newNode->next = nullptr;
    /*
    if (!P2) {
        P1 = P2 = newNode;
    }
    else {
        P2->next = newNode;
        P2 = newNode;
    }*/
    Node* new_node = new Node;
    new_node->data = value;
    new_node->next = nullptr;

    if (!p2_) {
        p1_ = p2_ = new_node;
    }
    else {
        p2_->next = new_node;
        p2_ = new_node;
    }
    //FIX_ME: лишнее повторное присваивание next = nullptr
    //newNode->next = nullptr;
}

bool Queue::pop(int& value) {  // Извлечение элемента из очереди
    if (!p1_) return false; // Очередь пуста

    Node* temp = p1_;
    value = p1_->data;
    p1_ = p1_->next;
    if (!p1_) {
        p2_ = nullptr; // Если очередь стала пустой
    }

    delete temp;
    return true;
}

void Queue::show() const { // Вывод элементов
    Node* temp = p1_;
    if (!temp) {
        std::cout << "Очередь пустая" << std::endl;
        return;
    }
    while (temp) {
        std::cout << temp->data << " ";
        temp = temp->next;
    }
    std::cout << std::endl;
}

//FIX_ME: отсутствие проверки, что очередь пустая
void Queue::even_head() { // Извлечение элементов, пока не встретится четное значение
    /*int num;
    while (!(P1 == nullptr) && (P1->data % 2 != 0)) {
        pop(num);
        cout << num << " ";
    }
    cout << endl;*/

    if (!p1_) {
        std::cout << "(очередь пустая)" << std::endl;
        return;
    }

    int value;
    while (p1_ && (p1_->data % 2 != 0)) {
        pop(value);
        std::cout << value << " ";
    }
    std::cout << std::endl;

}

//удаляет все элементы очереди
Queue::~Queue() {
    //FIX_ME: деструктор оставлен, но поля переименованы
    int deleted_value;
    while (pop(deleted_value));
}

Queue::Node* Queue::get_p1() const {
    return p1_;
}

Queue::Node* Queue::get_p2() const {
    return p2_;
}

//FIX_ME: обращение к P1->data при P1 == nullptr вызывает падение программы
/* void getP1data() const {
    int num1 = P1->data;
    cout << num1;
}*/
void Queue::get_p1_data() const {
    if (!p1_) {
        std::cout << "nullptr";
        return;
    }
    std::cout << p1_->data;
}

//FIX_ME: обращение к P2->data при P2 == nullptr вызывает падение программы
/*void getP2data() const {
    int num1 = P2->data;
    cout << num1;
}*/
void Queue::get_p2_data() const {
    if (!p2_) {
        std::cout << "nullptr";
        return;
    }
    std::cout << p2_->data;
}

