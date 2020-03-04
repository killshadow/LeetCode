package com.killshadow.exam.primary;

import java.util.Arrays;

public class PrimarySecond {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 7, 1}, {2, 4, 0}, {9, 4, 2}
        };
        int[][] ans = new PrimarySecond().calculate(matrix);
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }

    /**
     * Calculate new matrix by matrixA
     * @param matrixA input matrix which need to be calculated
     * @return new matrix which has been calculate
     */
    public int[][] calculate(int[][] matrixA) {
        int colLen = matrixA[0].length;
        int rowLen = matrixA.length;
        int[][] ans = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                ans[i][j]+=matrixA[i][j];
                if (i != 0) {
                    ans[i][j] += ans[i - 1][j];
                }
                if (j != 0) {
                    ans[i][j] += ans[i][j - 1];
                }
                if (i != 0 && j != 0) {
                    ans[i][j] += - ans[i - 1][j - 1];
                }
            }
        }
        return ans;
    }
}
