package com.killshadow.leetcode;

import com.killshadow.utils.MyArray;

import java.util.Arrays;

/**
 * User: killshadow
 * Date: 2021/9/12 0012
 * Description:
 */
public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = MyArray.stringToInt2dArray("[[1,3,1],[1,5,1],[4,2,1]]");
        MinPathSum minPathSum = new MinPathSum();
        System.out.println(minPathSum.minPathSum(grid)); // 7
        int[][] grid2 = MyArray.stringToInt2dArray("[[1,2,3],[4,5,6]]");
        System.out.println(minPathSum.minPathSum(grid2)); // 12
    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[row - 1][col - 1];
    }
}
