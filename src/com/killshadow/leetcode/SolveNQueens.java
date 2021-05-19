package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens {
    public static void main(String[] args) {
        List<List<String>> res = new SolveNQueens().solveNQueens(5);
        res.forEach(list -> System.out.println(Arrays.toString(list.toArray())));
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] trace = new char[n][n];
        Arrays.stream(trace).forEach(chars -> Arrays.fill(chars, '.'));
        List<List<String>> res = new ArrayList<>();
        backtrack(res, trace, 0);
        return res;
    }

    public void backtrack(List<List<String>> res, char[][] trace, int row) {
        // 1. 结束条件
        if (row == trace.length) {
            List<String> tmp = new ArrayList<>();
            Arrays.stream(trace).forEach(chars -> tmp.add(new String(chars)));
            res.add(tmp);
            return;
        }

        // 2. 遍历每行所有的元素
        for (int i = 0; i < trace.length; i++) {
            if (!isValid(trace, row, i)) {
                continue;
            }
            trace[row][i] = 'Q';
            backtrack(res, trace, row + 1);
            trace[row][i] = '.';
        }
    }

    private boolean isValid(char[][] trace, int row, int col) {
        // 检查同一列上是否有皇后互相冲突
        for (int i = 0; i < trace.length; i++) {
            if (trace[i][col] == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (trace[i][j] == 'Q') {
                return false;
            }
        }

        // 检查右上方是否有皇后冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < trace.length; i--, j++) {
            if (trace[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
