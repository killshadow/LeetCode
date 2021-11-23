package com.killshadow.leetcode;

/**
 * User: killshadow
 * Date: 2021/11/7 0007
 * Description:
 */
public class MissingElement {
    public static void main(String[] args) {
        MissingElement element = new MissingElement();
//        System.out.println(element.missingElement(new int[]{4, 7, 9, 10}, 1)); // 5
//        System.out.println(element.missingElement(new int[]{4, 7, 9, 10}, 3)); // 8
//        System.out.println(element.missingElement(new int[]{1, 2, 4}, 3)); // 6
        System.out.println(element.missingElement(new int[]{746421, 1033196,
                1647541, 4775111, 7769817, 8030384}, 10)); // 746431
    }

    public int missingElement(int[] nums, int k) {
        int preSum = 0;
        for (int i = 1; i < nums.length; i++) {
            int tmp = preSum;
            preSum += nums[i] - nums[i - 1] - 1;
            if (preSum == k) {
                return nums[i] - 1;
            } else if (preSum > k) {
                return nums[i - 1] + (k - tmp);
            }
        }
        return nums[nums.length - 1] + (k - preSum);
    }
}
