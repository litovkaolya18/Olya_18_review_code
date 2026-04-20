#pragma once
#include <iostream>
//FIX_ME: использование using namespace std запрещено Google Style Guide
//using namespace std;
//Далее во всем коде будут прописанны std::

//FIX_ME: имя класса должно быть в стиле CamelCase
//class stack {
class Stack {

private:
    struct Node {

        //FIX_ME: имя поля d слишком короткое и нарушает стиль  
        //int d;
        int data; // Значение элемента.

        //FIX_ME: имя поля next должно быть в стиле lower_case_with_underscores
        //Node* next;
        Node* next_; // Указатель на следующий узел.

        //FIX_ME: конструктор использует старые имена полей и нарушает стиль
        //Node(int val) :d(val), next(nullptr) {}
        Node(int value); // Создаёт узел со значением value
    };

    //FIX_ME: имя переменной нарущает стить lower_case_with_underscores
    //Node* p1; //вершина
    Node* top_; // Вершина стека

    //FIX_ME: имя переменной cnt не отражает смысл и нарушает стиль
    //int cnt;
    int count_; // Количество элементов

public:
    //FIX_ME: конструктор использует старые имена переменных p1 и cnt
    //stack() : p1(nullptr), cnt(0) {}
    Stack();

    //FIX_ME: имя функции должно быть lower_case_with_underscores
    //void add(int x) {
    void add_element(int value); // Добавляет элемент на вершину стека

    //FIX_ME: имя функции должно быть lower_case_with_underscores
    //void topdel() { 
    void delete_top(); //извлечение 1 элемента и его удаление

    //FIX_ME: имя функции должно быть lower_case_with_underscores
    //void show() {
    void show_stack();  // Выводит все элементы стека
};