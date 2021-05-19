package com.killshadow.leetcode;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 3, 5};
        int amount = 11;
        System.out.println(new CoinChange().coinChange(coins, amount));
    }

    /**
     * dp[j]代表含义：填满容量为j的背包最少需要多少硬币
     * 初始化dp数组：因为硬币的数量一定不会超过amount，而amount <= 10^410
     * 4
     *  ，因此初始化数组值为10001；dp[0] = 0
     * 转移方程：dp[j] = min(dp[j], dp[j - coin] + 1)
     * 当前填满容量j最少需要的硬币 = min( 之前填满容量j最少需要的硬币, 填满容量 j - coin 需要的硬币 + 1个当前硬币）
     * 返回dp[amount]，如果dp[amount]的值为10001没有变过，说明找不到硬币组合，返回-1
     *
     * 链接：https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-dong-tai-gui-hua-e2nt7/
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == 10001 ? -1 : dp[amount];
    }
}
