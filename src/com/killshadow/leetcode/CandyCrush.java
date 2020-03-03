package com.killshadow.leetcode;

public class CandyCrush {
    public static void main(String[] args) {

    }
    public int[][] candyCrush(int[][] board) {
        int rLen = board.length;
        int cLen = board[0].length;
        boolean goon = false;

        for (int r = 0; r < rLen - 2; r++) {
            for (int c = 0; c < cLen; c++) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r + 1][c]) && v == Math.abs(board[r + 2][c])) {
                    board[r + 2][c] = board[r + 1][c] = board[r][c] = -v;
                    goon = true;
                }
            }
        }
        for (int c = 0; c < cLen - 2; c++) {
            for (int r = 0; r < rLen; r++) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r][c + 1]) && v == Math.abs(board[r][c + 2])) {
                    board[r][c + 2] = board[r][c + 1] = board[r][c] = -v;
                    goon = true;
                }
            }
        }

        for (int c = 0; c < cLen; c++) {
            int backupR = rLen - 1;
            for (int r = rLen - 1; r >= 0; r--) {
                if (board[r][c] > 0) {
                    board[backupR--][c] = board[r][c];
                }
            }
            while (backupR >= 0) {
                board[backupR--][c] = 0;
            }
        }
        return goon ? candyCrush(board) : board;
    }
}
