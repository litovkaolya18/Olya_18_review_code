#include "Header.h"
#include <iostream>

//FIX_ME: переменные переименованы под Google Style
void find(const std::vector<std::vector<int>>& dp, int k, int s,
	const std::vector<int>& weights, double& total_weight) {
	if (k == 0 || s == 0)
		return;
	if (dp[k][s] == dp[k - 1][s]) { // если коробка не была выбрана
		find(dp, k - 1, s, weights, total_weight);
	}
	else { 
		// если коробка была выбрана
		std::cout << k << " "; // выводим номер коробки
		total_weight += weights[k];
		// ищем оставшиеся коробки
		find(dp, k - 1, s - weights[k], weights, total_weight);
	}
}