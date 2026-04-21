#pragma once
#include <vector>

//FIX_ME: Имена переменных изменены на lower_case_with_underscores.
// Объявление функции восстановления решения
//void find(const std::vector<std::vector<int>>& a, int k, int s,
//  const std::vector<int>& w, double& weight);
void find(const std::vector<std::vector<int>>& dp, int k, int s,
    const std::vector<int>& weights, double& total_weight);