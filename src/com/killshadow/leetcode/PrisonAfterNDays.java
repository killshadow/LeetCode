package com.killshadow.leetcode;

import java.util.Arrays;

public class PrisonAfterNDays {
    public static void main(String[] args) {
        int[] cells = new int[]{0, 1, 0, 1, 1, 0, 0, 1};
        int N = 7;
        Arrays.toString(new PrisonAfterNDays().prisonAfterNDays(cells, N));
    }

    // 会超时
    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] tmp = new int[8];
        tmp[0] = tmp[7] = 0;
        int n = N % 14;
        if (n == 0) {
            n = 14;
        }
        while (n > 0) {
            for (int i = 1; i < 7; i++) {
//                cells[i] = cells[i - 1] ^ cells[i + 1];
                tmp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = Arrays.copyOf(tmp, 8);
            System.out.println(Arrays.toString(cells));
            n--;
        }
        return cells;
    }
}