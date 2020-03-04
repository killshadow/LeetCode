package com.killshadow.leetcode;

import java.util.Arrays;

public class DominantIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 1, 0};
        int[] nums1 = new int[]{1, 2, 3, 4};
        int[] nums2 = new int[]{0, 0, 3, 2};
        System.out.println(new DominantIndex().dominantIndex(nums1));
    }

    /**
     * Find max Dominan
     * @param nums input number array
     * @return max dominan index
     */
    public int dominantIndex(int[] nums) {
        int len = nums.length;
        int max = 0;
        int maxIdx = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        for (int i = 0; i < len; i++) {
            if (max == nums[i]) {
                maxIdx = i;
                continue;
            }
            if (2 * nums[i] > max) {
                return -1;
            }
        }
        return maxIdx;
    }
}