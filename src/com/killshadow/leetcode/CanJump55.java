package com.killshadow.leetcode;

/**
 * User: killshadow
 * Date: 2021/6/4 0004
 * Description:
 */
public class CanJump55 {
    public static void main(String[] args) {
        CanJump55 jump55 = new CanJump55();
        System.out.println(jump55.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump55.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(jump55.canJump(new int[]{0}));
        System.out.println(jump55.canJump(new int[]{0, 2, 3}));
    }

    /**
     * 贪心算法, 每步都求出最大的目的地, 然后判断这个目的地是否到达了数组终点
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxIndex = 0;
        int end = 0;
        for (int i = 0; (i < len) && (i <= end); i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (i == end) {
                end = maxIndex;
            }
            if (maxIndex >= len - 1) {
                return true;
            }
        }
        return false;
    }
}
