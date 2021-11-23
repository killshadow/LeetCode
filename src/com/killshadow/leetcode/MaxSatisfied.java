package com.killshadow.leetcode;

/**
 * User: killshadow
 * Date: 2021/10/29 0029
 * Description:
 */
public class MaxSatisfied {
    public static void main(String[] args) {

    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int len = customers.length;
        int ans = 0;
        int max = 0;
        int cur = 0;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                ans += customers[i];
                customers[i] = 0;
            }
            cur += customers[i];
            if (i - minutes >= 0) {
                cur -= customers[i - minutes];
            }
            max = Math.max(max, cur);
        }
        return ans + max;
    }
}
