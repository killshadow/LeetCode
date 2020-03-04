package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenPascalTriangle {
    public static void main(String[] args) {
        System.out.println(new GenPascalTriangle().generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int row = 1; row < numRows; row++) {
            List<Integer> nowRow = new ArrayList<>();
            List<Integer> preRow = triangle.get(row - 1);
            nowRow.add(1);
            for (int j = 1; j < row; j++) {
                nowRow.add(preRow.get(j) + preRow.get(j - 1));
            }
            nowRow.add(1);
            triangle.add(nowRow);
            String a = "";
        }
        return triangle;
    }
}