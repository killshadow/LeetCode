package com.killshadow.leetcode;

public class LargestOverlap {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1,1,0},{0,1,0},{0,1,0}};
        int[][] B = new int[][]{{0,0,0},{0,1,1},{0,0,1}};
        LargestOverlap overlap = new LargestOverlap();
        System.out.println(overlap.largestOverlap(A, B));
    }

    public int largestOverlap(int[][] A, int[][] B) {
        int len = A.length;
        int[][] count = new int[2 * len + 1][2 * len + 1];
        for (int iA = 0; iA < len; iA++) {
            for (int jA = 0; jA < len; jA++) {
                if (A[iA][jA] == 1) {
                    for (int iB = 0; iB < len; iB++) {
                        for (int jB = 0; jB < len; jB++) {
                            if (B[iB][jB] == 1) {
                                count[iA - iB + len][jA - jB + len]++;
                            }
                        }
                    }
                }
            }
        }
        int max = 0;
        for (int[] row : count) {
            for (int cnt : row) {
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}