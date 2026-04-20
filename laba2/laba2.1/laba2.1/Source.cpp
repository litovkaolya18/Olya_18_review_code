#include "Header.h"
#include <windows.h>

//FIX_ME: конструктор использует старые имена переменных p1 и cnt
//stack() : p1(nullptr), cnt(0) {}
Stack::Stack() : top_(nullptr), count_(0) {}

//FIX_ME: конструктор использует старые имена полей и нарушает стиль
//Node(int val) :d(val), next(nullptr) {}
Stack::Node::Node(int value) : data(value), next_(nullptr) {}

//FIX_ME: имя функции должно быть lower_case_with_underscores
//void add(int x) {
void Stack::add_element(int value) { 

    //FIX_ME: имя переменной нарушает стиль lower_case_with_underscores
      //Node* newnode = new Node(x);
    Node* new_node = new Node(value);

    //FIX_ME: код использует старые имена переменных newnode, p1, cnt
    /*newnode->next = p1;
    p1 = newnode;
    cnt++; */
    new_node->next_ = top_;
    top_ = new_node;
    count_++;
}


//FIX_ME: имя функции должно быть lower_case_with_underscores
//void topdel() { //извлечение 1 элемента и его удаление
void Stack::delete_top() { 

    //FIX_ME: имя переменной нарушает стиль и использует старые переменные
     //FIX_ME: отсутствие проверки на пустой стек - требуется исключение
     //Node* temp = p1;
    if (top_ == nullptr) {
        throw std::runtime_error("Стек пуст — удаление невозможно");
    }
    Node* old_top = top_;

    std::cout << "Первый элемент стека D(data) :" << std::endl;

    //FIX_ME: использование старых имён p1, d, next
    /*cout << p1->d << endl;
    if (p1->next == nullptr) {
        p1 = nullptr;
    }
    else {
        p1 = p1->next;
    }*/
    std::cout << top_->data << std::endl;
    if (top_->next_ == nullptr) {
        top_ = nullptr;
    }
    else {
        top_ = top_->next_;
    }

    //FIX_ME: строка превышает 80 символов
    //cout << "Адрес новой вершины p1 после извлечения 1 элемента: " << p1 << endl; // Вывод адреса новой вершины
    //FIX_ME: использование старых имён p1, d, temp, cnt
    //if (p1 != nullptr) {
    //    cout << "Значение новой вершины p1: " << p1->d << endl; // Вывод значения новой вершины
    //}
    //delete temp;
    //cnt--;
    std::cout << "Адрес новой вершины P2(top_): " << top_ << std::endl;
    if (top_ != nullptr) {
        std::cout << "Значение новой вершины P2(top_): " << top_->data << std::endl;
    }
    delete old_top;
    count_--;
}


//FIX_ME: имя функции должно быть lower_case_with_underscores
//void show() {
void Stack::show_stack() {

    //FIX_ME: использование старых имён p1, d, next
    /*Node* temp = p1;
    while (temp != nullptr) {
        cout << temp->d << endl;
        temp = temp->next;
    }*/
    Node* temp_node = top_;
    while (temp_node != nullptr) {
        std::cout << temp_node->data << std::endl;
        temp_node = temp_node->next_;
    }
}