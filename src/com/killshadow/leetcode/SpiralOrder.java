package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }};
        int[][] mat = new int[][]{
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(new SpiralOrder().spiralOrder(mat));
    }

    /**
     * Transfor matrix to array
     * @param matrix input matrix
     * @return array
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }
        int left = 0;
        int up = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;

        while (true) {
            // 上边界, 从左往右移动
            for (int i = left; i <= right; ++i) {
                ans.add(matrix[up][i]);
            }
            // 如果上边界的值大于下边界的, 则退出
            if (++up > down) {
                break;
            }

            // 右边界, 从上往下移动
            for (int i = up; i <= down; ++i) {
                ans.add(matrix[i][right]);
            }
            // 如果右边界的值小于左边界的, 则退出
            if (--right < left) {
                break;
            }

            // 下边界, 从右往左移动
            for (int i = right; i >= left; --i) {
                ans.add(matrix[down][i]);
            }
            // 如果下边界的值小于上边界的, 则退出
            if (--down < up) {
                break;
            }

            // 左边界, 从下往上移动
            for (int i = down; i >= up; --i) {
                ans.add(matrix[i][left]);
            }
            // 如果左边界的值大于右边界的, 则退出
            if (++left > right) {
                break;
            }
        }
        return ans;
    }
}
