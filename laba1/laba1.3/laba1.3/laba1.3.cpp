/*
К - ичные числа.Среди чисел в системе счисления с основанием K(2≤K≤10)
определить сколько  имеется чисел из N(1 < N < 20, N + K < 26) разрядов 
таких, что в их записи не содержится более трех подряд идущих нулей.Для
того, чтобы избежать переполнения, ответ представьте в виде вещественного числа
*/

#include "Header.h"
#include <iostream>
#include <cmath>
#include <string>
#include <vector>
#include <Windows.h>
//FIX_ME: убран using namespace std; по Google Style
// using namespace std;
//FIX_ME: стиль фигурных скобок и отступов приведён к Google Style

int main()
{
    SetConsoleCP(1251);
    SetConsoleOutputCP(1251);
    //FIX_ME: Добавлена инициализация
    //int k, n;
    int k = 0;
    int n = 0;

    while (true) {
        std::cout << "Введите основание системы счисления K(2 <= K <= 10): ";

        //FIX_ME: добавлена проверка на нечисловой ввод
        if (!(std::cin >> k)) {
            std::cout << "Ошибка: требуется число." << std::endl;

            //FIX_ME: очистка некорректного ввода без max
            std::cin.clear();
            std::string trash;
            std::getline(std::cin, trash);

            continue;
        }

        if (k >= 2 && k <= 10) {
            break;
        }

        std::cout << "Некорректный ввод. Повторите попытку." << std::endl;
    }

    while (true) {
        std::cout << "Введите кол-во разрядов N(1 < N < 20): ";

        if (!(std::cin >> n)) {
            std::cout << "Ошибка: требуется число." << std::endl;

            //FIX_ME: очистка мусора без max
            std::cin.clear();
            std::string trash;
            std::getline(std::cin, trash);

            continue;
        }

        if (n > 1 && n < 20 && (n + k) < 26) {
            break;
        }
        std::cout << "Некорректный ввод. Повторите попытку." << std::endl;
    }

    //FIX_ME: total → double по условию задачи.
    //double total = 0;
    double total = 0.0;

    for (int value = std::pow(k, n - 1); value < std::pow(k, n); value++) {
        std::string num = "";
        int temp = value;

        if (k != 10) {
            for (int pos = 0; pos < n; pos++) {
                num = std::to_string(temp % k) + num;
                temp /= k;
            }
        }

        if (num[0] != '0' && no_three_zeros(num)) {
            total++;
        }
    }

    std::cout << "Количество чисел: " << total << std::endl;
    return 0;
}