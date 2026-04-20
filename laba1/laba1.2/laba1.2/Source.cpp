#include "Header.h"
#include <algorithm>
#include <vector>

//FIX_ME: Имя функции изменено под Google Style, параметр board2 → dp
//void solve(const std::vector<std::vector<int>>& board, std::vector<std::vector<int>>& board2, int n)
void solve(const std::vector<std::vector<int>>& board,
    std::vector<std::vector<int>>& dp, int n) {

    //FIX_ME: Имена переменных изменены на lower_case_with_underscores.
    //int i, j;
    int row = 0;
    int col = 0;

    dp[n - 1][n - 1] = board[n - 1][n - 1];

    for (row = n - 2; row >= 0; --row) {
        dp[row][n - 1] = dp[row + 1][n - 1] + board[row][n - 1];
    }

    for (col = n - 2; col >= 0; --col) {
        dp[n - 1][col] = dp[n - 1][col + 1] + board[n - 1][col];
    }

    for (row = n - 2; row >= 0; --row) {
        for (col = n - 2; col >= 0; --col) {
            if (dp[row + 1][col] > dp[row][col + 1]) {
                dp[row][col] = dp[row + 1][col] + board[row][col];
            }
            else {
                dp[row][col] = dp[row][col + 1] + board[row][col];
            }
        }
    }
}

std::string build_path(const std::vector<std::vector<int>>& dp, int n) {
    //FIX_ME: Имя переменной изменено с s на path.
    //Старый код:
    //string s = "";
    std::string path;

    //FIX_ME: переменные переименованы под Google Style
    //int i = 0, j = 0;
    int row = 0;
    int col = 0;

    while (row < n - 1 || col < n - 1) {
        if (row < n - 1 && col < n - 1) {
            if (dp[row + 1][col] > dp[row][col + 1]) {
                path += 'U';
                ++row;
            }
            else {
                path += 'L';
                ++col;
            }
        }
        else if (row < n - 1) {
            path += 'U';
            ++row;
        }
        else {
            path += 'L';
            ++col;
        }
    }

    std::reverse(path.begin(), path.end());
    return path;
}