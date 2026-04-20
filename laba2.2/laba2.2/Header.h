#pragma once
#include <iostream>

//FIX_ME: поля и методы приведены к Google Style
class Queue {
public:
    struct Node {
        int data;   // Значение элемента очереди
        Node* next; // Указатель на следующий узел
    };
    Queue();  // Создаёт пустую очередь 
    ~Queue(); // Освобождает всю память

    // void push(int num);
    // bool pop(int& num);
    // void EvenHead();
    void push(int value); // Добавляет новый элемент в конец очереди
    bool pop(int& value); // Удаляет элемент из начала очереди.
    void show() const;    // Выводит все элементы очереди на экран
    // Извлекает элементы, пока первый элемент не станет чётным.
    void even_head();

    //Node* getP1() const;
    //Node* getP2() const;
    // Возвращает указатель на первый элемент очереди (head)
    Node* get_p1() const;
    // Возвращает указатель на последний элемент очереди (tail)
    Node* get_p2() const;

    //void getP1data() const;
    //void getP2data() const;
    // Выводит значение первого элемента или "nullptr", если очередь пуста
    void get_p1_data() const; 
    // Выводит значение последнего элемента или "nullptr", если очередь пуста
    void get_p2_data() const; 

private:
    //Node* P1;
    //Node* P2;
    Node* p1_; // Указатель на начало очереди (head)
    Node* p2_; // Указатель на конец очереди (tail)
};
