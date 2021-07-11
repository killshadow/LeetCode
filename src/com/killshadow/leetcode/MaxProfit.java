package com.killshadow.leetcode;

public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit profit = new MaxProfit();
        System.out.println(profit.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(profit.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(profit.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(profit.maxProfit2(new int[]{7, 6, 4, 3, 1}));
    }

    /**
     * 121: https://leetcde-cn.com/problems/best-time-to-buy-and-sell-stock/
     *
     * 状态转移方程为:
     * 两种情况: 昨天没有持有股票,今天也没有持有股票,利润不变; 昨天持有了股票,今天卖出了股票,利润加上今天的股价
     * dp[i][k][0] = max(dp[i-1][k][0],dp[i-1][k][1] + prices[i])
     * 两种情况: 昨天持有股票,今天也持有股票,利润不变; 昨天没有持有股票,今天买了股票,利润减去今天的股价
     * dp[i][k][1] = max(dp[i-1][k][1],dp[i-1][k-1][0] - prices[i])
     *
     * @param prices 每天的股价
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 由于该问题只能用
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int dayNum = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < dayNum; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }
}
