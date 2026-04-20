#pragma once
#include <iostream>
//FIX_ME: поля и методы приведены к Google Style

//FIX_ME: структура Uzel должна быть классом по требованию задания
//struct Uzel {
//    int Znachenie;
//    Uzel* Predydushiy;
//    Uzel* Sleduyushiy;
//};
class Node {
public:
    int value;       // значение узла
    Node* prev;      // указатель на предыдущий узел
    Node* next;      // указатель на следующий узел

    //FIX_ME: не было конструктора — нарушение ООП
    Node(int v);
};

// Класс двусвязного списка
class DoublyList {
private:
    //FIX_ME: имя PerviyElement нарушало стиль и было на русском
    //Uzel* PerviyElement;
    Node* head;

public:
    DoublyList();   // создаёт пустой список
    ~DoublyList();  // очищает список

    //void DobavitElement(int Znachenie);
    // добавляет элемент в конец списка
    void add(int value);
    
    //FIX_ME: раньше не было удаления одного элемента — требование задания
    void remove_node(Node* node); // удаляет один узел
    
    //void Ochistka();
    // очищает весь список
    void clear();
    
    //void VivodSpiska();
    // выводит элементы списка
    void print();
    
    //void PoiskMinMax(Uzel*& Min, Uzel*& Max);
    // находит минимальный и максимальный элементы
    void find_min_max(Node*& min_node, Node*& max_node);
   
    //bool ProverkaPoryadka(Uzel* A, Uzel* B);
    // проверяет порядок следования узлов
    bool is_first(Node* a, Node* b);
    
    //void VivodMezhduMinMax();
    // выводит элементы между min и max
    void print_between_min_max();
    

    //FIX_ME: отсутствовал дружественный интерфейс
    friend void print_between_min_max(DoublyList& list);
};


// дружественная функция
void print_between_min_max(DoublyList& list);