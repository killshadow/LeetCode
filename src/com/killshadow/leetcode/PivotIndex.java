package com.killshadow.leetcode;

import java.util.List;

public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(new PivotIndex().pivotIndex(new int[]{1, 2, 3}));
    }

    /**
     * get Pivot Index
     * @param nums Input Array
     * @return Pivot Index
     */
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int leftSum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < len; i++) {
            if (sum - (leftSum + nums[i]) == leftSum) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }
        return -1;
    }
}
