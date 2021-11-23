package com.killshadow.leetcode;

import java.util.Arrays;

/**
 * User: killshadow
 * Date: 2021/9/15 0015
 * Description:
 */
public class Solve {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        Solve solve130 = new Solve();
        solve130.solve(board);
        Arrays.stream(board).forEach(arr -> System.out.println(Arrays.toString(arr)));

        char[][] board2 = new char[][] {
                {'X','O','X'},
                {'O','X','O'},
                {'X','O','X'}
        };
        solve130.solve(board2);
        Arrays.stream(board2).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    /**
     * 深搜查找边界上连同的O,并标记,然后把剩下所有的O替换成X,最后把标记还原
     *
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }

        for (int j = 0; j < board[0].length; j++) {
            dfs(board, 0, j);
            dfs(board, board.length - 1, j);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    public void dfs(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') {
            return;
        }
        board[row][col] = '-';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}
