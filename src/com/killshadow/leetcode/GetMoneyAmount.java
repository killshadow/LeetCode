package com.killshadow.leetcode;

public class GetMoneyAmount {
    public static void main(String[] args) {
        System.out.println(new GetMoneyAmount().getMoneyAmount(10));
    }

    private int cost(int low, int high) {
        if (low >= high) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = (low + high) / 2; i <= high; i++) {
            int res = i + Math.max(cost(low, i - 1), cost(i + 1, high));
            min = Math.min(min, res);
        }
        return min;
    }

    public int getMoneyAmount(int n) {

        return cost(1, n);
    }
}
