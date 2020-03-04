package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindDiagonalOrder {
    public static void main(String[] args) {

    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[] nums = new int[m * n];
        int row = 0;
        int col = 0;
        // m+n是总数目
        for (int i = 0; i < nums.length; i++) {
            // 先赋值
            nums[i] = matrix[row][col];
            // row+col即为当前遍历的层数, 为偶数时, 向上遍历, 奇数向下遍历
            if ((row + col) % 2 == 0) {
                if (col == n - 1) {
                    // 当col==n-1时, 说明当前层已经到最右边界, row要+1下移向下遍历
                    row++;
                } else if (row == 0) {
                    // 当col为0时, 说明当前层已经到斜向上的顶了, col要+1右移向下增长.
                    col++;
                } else {
                    // 否则, 说明在中间
                    row--;
                    col++;
                }
            } else {
                // 这是向上遍历的情况
                if (row == m - 1) {
                    // 此时说明到最下边界, col+1准备向上遍历
                    col++;
                } else if (col == 0) {
                    // 当col==0时, 说明已经到最左边界, row要+1下移向上遍历
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return nums;
    }
}