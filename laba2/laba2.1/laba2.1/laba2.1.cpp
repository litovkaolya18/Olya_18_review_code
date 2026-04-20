/*
Дан указатель P1 на вершину непустого стека. Извлечь из стека первый (верхний)
элемент и вывести его значение D, а также адрес P2 новой вершины стека. 
Если послеизвлечения элемента стек окажется пустым, то положить P2 = nullptr. 
После извлечения элемента из стека освободить память, занимаемую этим 
элементом.

Для каждой динамической структуры должен быть предусмотрен стандартный набор
методов - добавления/удаления/вывода элементов.
Во всех задачах обязательно наличие дружественного интерфейса. 
Ввод данных с клавиатуры.

В заданиях подгруппы структура «стек» (stack) моделируется цепочкой связанных
узлов-записей типа TNode. Поле Next последнего элемента цепочки равно nullptr.
Вершиной стека (top) считается первый элемент цепочки. Для доступа к стеку 
используется указатель на его вершину (для пустого стека данный указатель 
полагается равным nullptr). Значением элемента стека считается значение 
его поля Data*/



#include <iostream>
#include "Header.h"
//FIX_ME: добавлена библиотека Windows API для установки кодировки консоли
#include <windows.h>

int main() {
  SetConsoleOutputCP(65001);
  SetConsoleCP(65001);
  setlocale(LC_ALL, "RU");

  //FIX_ME: использование старых имён класса stack, метода add, show, topdel
  //stack stack;
  Stack stack;

  std::cout << "Введите количество элементов стека" << std::endl;

  //FIX_ME: имя переменной n нарушает стиль lower_case_with_underscores
  //int n;
  //std::cin >> n;//размер стека
  //for (int i = 0; i < n; i++) {
  int element_count;

  //FIX_ME: добавлена проверка на корректный ввод количества
  while (true) {
      std::cin >> element_count;
      if (std::cin.fail() || element_count < 0) {
          std::cin.clear();               // сброс ошибки
          std::cin.ignore(10000, '\n');   // очистка ввода
          std::cout << "Ошибка! Введите неотрицательное число." << std::endl;
          continue;
      }
      break;
  }


  for (int i = 0; i < element_count; i++) {

      //FIX_ME: имя переменной num не отражает смысл и нарушает стиль
      //int num;
      //std::cin >> num;
      int element_value;

      std::cout << "Введите элемент стека" << std::endl;

      //FIX_ME: добавлена проверка на корректный ввод элемента
      while (true) {
          std::cin >> element_value;
          if (std::cin.fail()) {
              std::cin.clear();
              std::cin.ignore(10000, '\n');
              std::cout << "Ошибка! Введите целое число." << std::endl;
              continue;
          }
          break;
      }

      //stack.add(num);
      stack.add_element(element_value);
  }
  std::cout << "Стек:" << std::endl;

  //stack.show();
  stack.show_stack();

  try {
      stack.delete_top();
  }
  catch (const std::exception& e) {
      std::cout << "Ошибка: " << e.what() << std::endl;
  }

  return 0;
}
