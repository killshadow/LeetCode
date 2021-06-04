package com.killshadow.leetcode;

/**
 * User: killshadow
 * Date: 2021/6/4 0004
 * Description:
 */
public class CanCompleteCircuit {
    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        CanCompleteCircuit canCompleteCircuit = new CanCompleteCircuit();
        System.out.println(canCompleteCircuit.canCompleteCircuit(gas, cost));
    }

    /**
     * 计算每经过到达下一加油站剩余的油量, 如果总剩余油量小于0, 则说明无法绕环路行驶一周.
     * 否则, 总剩余油量最小的下一油站, 便是最合适的出发点, 因为这时候到终点油量是最少的.
     *
     * 遍历全部加油站，总是以剩余油量最低的一站的下一站为返回结果，如果总剩余油量小于0，则无法走完一圈.
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int current = 0;
        int minOil = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            current += gas[i] - cost[i];
            if (current < minOil) {
                minOil = current;
                ans = i + 1;
            }
        }

        if (current < 0) {
            return -1;
        }

        return ans;
    }
}
