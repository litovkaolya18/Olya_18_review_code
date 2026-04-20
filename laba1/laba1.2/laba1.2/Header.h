#pragma once
#include <vector>
#include <string>

//FIX_ME: Имя функции изменено с CamelCase на lower_case_with_underscores
//void Solve(const vector<vector<int>>& board, vector<vector<int>>& board2, int n)
//Вычисляет таблицу максимальных сумм
void solve(const std::vector<std::vector<int>>& board,
    std::vector<std::vector<int>>& dp, int n);

//FIX_ME: Имя функции изменено с CamelCase на lower_case_with_underscores
//string Path(const vector<vector<int>>& board2, int n)
//Восстанавливает путь по таблице максимальных сумм
std::string build_path(const std::vector<std::vector<int>>& dp, int n);