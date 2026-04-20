/*
Все динамические структуры данных реализовывать через классы. 
Не использовать STL. Для каждой динамической структуры должен быть предусмотрен
стандартный набор методов - добавления/удаления/вывода элементов.
Во всех задачах обязательно наличие дружественного интерфейса. Ввод данных с 
клавиатуры.

Дан односвязный линейный список и указатель на голову списка P1. Необходимо
вставить значение M перед каждым вторым элементом списка, и вывести ссылку 
на последний элемент полученного списка P2. При нечетном числе элементов 
исходного списка в конец списка вставлять не надо.
*/

#include <iostream>
#include "Header1.h"
//FIX_ME: добавлена библиотека Windows API для установки кодировки консоли
#include <windows.h>
//FIX_ME: убран using namespace std; по Google Style
//старый код
// using namespace std;


int main() {
    SetConsoleOutputCP(65001);
    SetConsoleCP(65001);
    setlocale(LC_ALL, "RU");

    LinkedList list; // Создаем список

    //FIX_ME: переменная нарушает стиль — меняем на lower_case_with_underscores
    //int n, value, M;
    int element_count, value, m;

    std::cout << "Введите количество элементов в списке: ";

    //FIX_ME: отсутствовала проверка на корректный ввод количества элементов.
    //std::cin >> element_count;
    while (true) {
        std::cin >> element_count;
        if (std::cin.fail() || element_count < 0) {
            std::cin.clear();
            std::cin.ignore(10000, '\n');
            std::cout << "Ошибка! Введите неотрицательное число." << std::endl;
            continue;
        }
        break;
    }

    std::cout << "Введите элементы списка: ";
    for (int i = 0; i < element_count; ++i) {

        //FIX_ME: отсутствовала проверка на корректный ввод каждого элемента
        //std::cin >> value;               
        while (true) {
            std::cin >> value;  // Вводим значение элемента
            if (std::cin.fail()) {
                std::cin.clear();
                std::cin.ignore(10000, '\n');
                std::cout << "Ошибка! Введите целое число." << std::endl;
                continue;
            }
            break;
        }
        list.add(value); // Добавляем элемент в список
    }

    std::cout << "Введите значение M для вставки: ";

    //FIX_ME: отсутствовала проверка на корректный ввод значения m
    //std::cin >> m;
    while (true) {
        std::cin >> m;
        if (std::cin.fail()) {
            std::cin.clear();
            std::cin.ignore(10000, '\n');
            std::cout << "Ошибка! Введите целое число." << std::endl;
            continue;
        }
        break;
    }

    // Вставка значения M перед каждым вторым элементом
    insert_before_every_second(list, m);

    std::cout << "Список после вставки: ";
    list.print();

    // Получение указателя на последний элемент списка
    //FIX_ME: имя переменной нарушает стиль — CamelCase запрещён
    //Node* lastNode = list.get_last_node();
    Node* last_node = list.get_last_node();

    // Вывод результата
    if (last_node != nullptr) {
        std::cout << "Указатель на последний элемент списка: " << 
            last_node << std::endl;
        std::cout << "Значение 1-го элемента: " << last_node->data << 
            std::endl;
    }
    else {
        std::cout << "Список очищен." << std::endl;
    }
    list.clear_list();

    // Проверка, что список пуст
    std::cout << "Проверка списка после очистки: ";
    list.print();

    return 0;
}