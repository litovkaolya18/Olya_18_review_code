#pragma once
#include <iostream>

//FIX_ME: поля и методы приведены к Google Style
class Queue {
public:
    struct Node {
        int data;
        Node* next;
    };
    Queue();
    ~Queue();

    //void push(int num);
    // bool pop(int& num);
    //void EvenHead();
    void push(int value);
    bool pop(int& value);
    void show() const;
    void even_head();

    //Node* getP1() const;
    //Node* getP2() const;
    Node* get_p1() const;
    Node* get_p2() const;

    //void getP1data() const;
    //void getP2data() const;
    void get_p1_data() const;
    void get_p2_data() const;

private:
    //Node* P1;
    //Node* P2;
    Node* p1_;
    Node* p2_;
};
