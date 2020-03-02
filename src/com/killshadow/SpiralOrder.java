package com.killshadow;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        // A, B, C, D分别为矩形的左上/右上/左下/右下角
        int up = 0;
        int right = matrix.length - 1;
        int left = 0;
        int down = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();
        while (true) {
            for (int i = up; i <= right; i++) {
                list.add(i);
            }
            if (right-- < 0) {
                break;
            }
            for (int i = right)
        }
    }
}
