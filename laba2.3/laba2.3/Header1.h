#pragma once

class Node {
public:
    int data; // данные узла
    Node* next; // указатель на следующий элемент списка
    Node(int value); // конструктор: создаёт узел со значением 
};

class LinkedList {
private:
    Node* head; // указатель на первый элемент списка

public:
    LinkedList();

    // добавляет новый элемент в конец списка
    void add(int value);

    //FIX_ME: имя метода нарушает Google Style.
    //void insertBeforeEverySecond(int M);
    // вставляет значение m перед каждым вторым элементом списка
    void insert_before_every_second(int m);
    
    // выводит все элементы списка слева направо
    void print();

    //FIX_ME: имя метода нарушает стиль — CamelCase запрещён для функций
    //Node* getLastNode();
     // возвращает указатель на последний элемент списка (для вывода P2)
    Node* get_last_node();

    //FIX_ME: имя метода нарушает стиль — CamelCase запрещён
    //void clearList();
    // полностью очищает список и освобождает память
    void clear_list();

    //FIX_ME: имя функции нарушает стиль — CamelCase запрещён
    //friend void insertBeforeEverySecond(LinkedList& list, int M);
    // позволяет вызывать вставку как обычную функцию
    friend void insert_before_every_second(LinkedList& list, int m);
};

// внешний интерфейс для вызова вставки
void insert_before_every_second(LinkedList& list, int m);
