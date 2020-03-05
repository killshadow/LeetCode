package com.killshadow.leetcode;

public class GetMoneyAmount {
    public static void main(String[] args) {

    }

    private int cost(int low, int high) {
        if (low > high) {
            return 0;
        }
        int minres = Integer.MAX_VALUE;
        for (int i = low; i < high; i++) {
            int res = i + Math.max(cost(low, i), cost(i + 1, high));
            minres = Math.min(minres, res);
        }
        return minres;
    }

    public int getMoneyAmount(int n) {

        return cost(1, n);
    }
}
