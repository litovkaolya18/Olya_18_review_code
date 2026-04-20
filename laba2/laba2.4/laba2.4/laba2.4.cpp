/* Дан двусвязный линейный список и указатель первый элемент этого
списка. Все элементы списка хранят различные между собой значения. Необходимо
вывести значения элементов списка, которые находятся между наименьшим и
наибольшим элементами списка, в том порядке, в каком они находятся в исходном
списке. Использовать процедуры.

Все динамические структуры данных реализовывать через классы. Не использовать STL.  
Для каждой динамической структуры должен быть предусмотрен
стандартный набор методов - добавления/удаления/вывода элементов.
Во всех задачах обязательно наличие дружественного интерфейса. Ввод данных с клавиатуры.*/

#include "Header.h"
#include <iostream>
#include <string>
//FIX_ME: добавлена библиотека Windows API для установки кодировки консоли
#include <windows.h>
//FIX_ME: убран using namespace std; по Google Style
// using namespace std;

//FIX_ME: используем актуальные имена переменных и полей 

//FIX_ME: добавлена проверка корректного ввода целого числа
bool read_int(int& result) {
    std::string input;
    std::cin >> input;

    // проверяем, что строка состоит только из цифр (и опционального минуса)
    int start = (input[0] == '-') ? 1 : 0;

    if (start == 1 && input.size() == 1) {
        return false;  // строка = "-" → не число
    }

    for (size_t i = start; i < input.size(); i++) {
        if (!std::isdigit(static_cast<unsigned char>(input[i]))) {
            return false;
        }
    }

    result = std::stoi(input);
    return true;
}


int main() {
    setlocale(LC_ALL, "Russian");

    //FIX_ME: старый код использовал имя Spisok и тип Spisok
    //Spisok Spisok;
    //Spisok.Initsializatsiya();
    DoublyList list;

    int n;
    std::cout << "Введите количество элементов: ";

    //FIX_ME: старый код не проверял fail() у cin
    //if (N <= 0) {
    //    cout << "Некорректное число!" << endl;
    //    return 0;
    //}
    while (!read_int(n) || n <= 0) {
        std::cout << "Ошибка! Введите положительное число: ";
    }

    std::cout << "Вводите элементы:" << std::endl;

    for (int i = 0; i < n; i++) {
        //FIX_ME: логика та же, но имена приведены к стилю
        //int Chislo;
        //if (!(cin >> Chislo)) {
        //    cout << "Ошибка ввода!" << endl;
        //    return 0;
        //}
        //Spisok.DobavitElement(Chislo);
        int value;
        std::cout << "Элемент " << i + 1 << ": ";

        //FIX_ME: проверка на дурака
        while (!read_int(value)) {
            std::cout << "Ошибка! Введите целое число: ";
        }

        list.add(value);
    }

    std::cout << "Список: ";
    list.print();

    //FIX_ME: раньше вызывался метод класса, а не дружественная функция
     //Spisok.VivodMezhduMinMax();
    print_between_min_max(list);

    //FIX_ME: раньше очистка вызывалась явно через Ochistka()
    //Spisok.Ochistka();
    return 0;
}