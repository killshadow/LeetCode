package com.killshadow.leetcode;

/**
 * User: killshadow
 * Date: 2021/11/19 0019
 * Description:
 */
public class SolveSudoku {
    public static void main(String[] args) {
        System.out.println((5 / 3) * 3);
        System.out.println((2 / 3) * 3);
    }

    public void solveSudoku(char[][] board) {

    }

    private boolean[][] isExistInRow = new boolean[9][9];
    private boolean[][] isExistInCol = new boolean[9][9];
    private boolean[][] isExistInGrid = new boolean[9][9];
    private int[][] direct = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private void backtrack(char[][] sdk, int row, int col) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int m = i * 3; m < i * 3 + 3; m++) {
                    for (int n = j * 3; n < j * 3 + 3; n++) {

                    }
                }
            }
        }
    }

    private boolean isValidRow(char[][] sdk, int row) {
        boolean[] dp = new boolean[9];
        for (int i = 0; i < 9; i++) {
            char val = sdk[row][i];
            if (val == '.') {
                continue;
            }
            if (dp[val]) {
                return false;
            }
            dp[val] = true;
        }
        return true;
    }

    private boolean isValidCol(char[][] sdk, int col) {
        boolean[] dp = new boolean[9];
        for (int i = 0; i < 9; i++) {
            char val = sdk[i][col];
            if (val == '.') {
                continue;
            }
            if (dp[val]) {
                return false;
            }
            dp[val] = true;
        }
        return true;
    }

    private boolean isValidGrid(char[][] sdk, int row, int col) {
        int gRow = (row / 3) * 3;
        int gCol = (col / 3) * 3;
        boolean[] dp = new boolean[9];
        for (int i = gRow; i < gRow + 3; i++) {
            for (int j = gCol; j < gCol + 3; j++) {
                char val = sdk[i][j];
                if (val == '.') {
                    continue;
                }
                if (dp[val]) {
                    return false;
                }
                dp[val] = true;
            }
        }
        return true;
    }
}
