/* Даны указатели P1 и P2 на начало и конец непустой очереди. 
Извлекать из очереди элементы, пока значение начального элемента
очереди не станет четным, и выводить значения извлеченных элементов
(если очередь не содержит элементов с четными значениями, то извлечь
все ее элементы).Вывести также новые адреса начала и конца очереди
(для пустой очереди дважды вывести nullptr).После извлечения элементов
из очереди освобождать память, которую они занимали.

Для каждой динамической структуры должен быть предусмотрен стандартный
набор методов - добавления/удаления/вывода элементов. Во всех задачах
обязательно наличие дружественного интерфейса. Ввод данных с клавиатуры.

В заданиях данной подгруппы структура «очередь» (queue) моделируется 
цепочкой связанных узлов-записей типа TNode. Поле Next последнего 
элемента цепочки равно nullptr. Началом очереди («головой», head)
считается первый элемент цепочки, концом («хвостом», tail) — ее
последний элемент. Для возможности быстрого добавления в конец очереди 
нового элемента удобно хранить, помимо указателя на начало очереди, 
также и указатель на ее конец. В случае пустой очереди указатели на ее
начало и конец полагаются равными nullptr. Как и для стека,
значением элемента очереди считается значение его поля Data.*/

#include "Header.h"
#include <iostream>
#include <string>
#include <cctype>
//FIX_ME: добавлена библиотека Windows API для установки кодировки консоли
#include <windows.h>
//FIX_ME: убран using namespace std; по Google Style
//старый код
// using namespace std;

//FIX_ME: используем актуальные имена переменных и полей 
//FIX_ME: имя функции должно быть в стиле Google (snake_case)
//bool IsNumber(const string& str) {
bool is_number(const std::string& str) {
    if (str.empty()) {
        return false;
    }
    int start = (str[0] == '-' || str[0] == '+') ? 1 : 0;

    //FIX_ME: неправильная проверка символов — isdigit() требует unsigned char,
    //также str.length() имеет тип size_t, поэтому нужен static_cast<int>
    /*for (int i = start; i < str.length(); ++i) {
        if (!isdigit(str[i])) return false;
    }
    return start < str.length();*/
    for (int i = start; i < static_cast<int>(str.length()); ++i) {
        if (!isdigit(static_cast<unsigned char>(str[i]))) {
            return false;
        }
    }
    return start < static_cast<int>(str.length());
}

 
int main() {
    //FIX_ME: setlocale не меняет кодировку консоли в Windows
    //setlocale(LC_ALL, "ru");
    SetConsoleOutputCP(1251);
    SetConsoleCP(1251);

    //FIX_ME: переменные должны быть в snake_case
    //Queue q;
    // string in, inum;
    // int num, n;
    Queue queue;
    std::string input_count;
    std::string input_element;
    int value;
    int element_count;

    std::cout << "Введите количество элементов в очереди: ";
    std::cin >> input_count;

    if (!is_number(input_count)) {
        std::cout << "Недопустимое значение.";
        return 1;
    }

    
    //FIX_ME: stoi может выбросить исключение → добавлен try/catch
    //n = stoi(in);
    try {
        element_count = std::stoi(input_count);
    }
    catch (...) {
        std::cout << "Ошибка: число слишком большое\n";
        return 1;
    }
     
   
    //FIX_ME: отсутствовала проверка на отрицательное число
    if (element_count < 0) {
        std::cout << "Ошибка: число элементов не может быть отрицательным\n";
        return 1;
    }

    std::cout << "Введите элементы очереди: ";
    //FIX_ME: цикл должен идти от 0 до n-1
    //for (int i = 1; i <= n; i++) {
    for (int i = 0; i < element_count; i++) {
        std::cin >> input_element;

        //FIX_ME: отсутствовала проверка, что элемент — число
        //добавленны более развернутые комментарии 
        if (!is_number(input_element)) {
            //cout << "Недопустимое значение.";
            std::cout << "Ошибка: элемент должен быть целым числом.\n";
            return 1;
        }

        //FIX_ME: отсутствует проверка, если число слишком большое,
        // stoi может переполниться
        //else {
        //    num = stoi(inum);
        //    q.push(num);
        //}
        try {
            value = std::stoi(input_element);
        }
        catch (...) {
            std::cout << "Ошибка: число слишком большое\n";
            return 1;
        }
        queue.push(value);
    }

    std::cout << "Изначальная очередь: ";
    queue.show();

    std::cout << "Извлеченные элементы: ";
    queue.even_head();

    std::cout << "Измененная очередь: ";
    queue.show();

    std::cout << "Значение первого элемента: ";
    queue.get_p1_data();
    std::cout << std::endl;

    std::cout << "Новый адрес начала очереди (P1): " << queue.get_p1() << std::endl;

    std::cout << "Значение последнего элемента: ";
    queue.get_p2_data();
    std::cout << std::endl;

    std::cout << "Новый адрес конца очереди (P2): " << queue.get_p2() << std::endl;

    return 0;
}