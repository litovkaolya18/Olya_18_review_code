#include "Header.h"

//FIX_ME: имя функции изменено под Google Style
//bool NoThreeZeros(string &num)
bool no_three_zeros(std::string& num) {
  //FIX_ME: стиль фигурных скобок и отступов приведён к Google Style
  int zero_count = 0;  

  for (char ch : num) {
      if (ch == '0') {
          zero_count++;
          if (zero_count > 3) {
              return false;
          }
      }
      else {
          zero_count = 0;
      }
  }
  return true;
}