package com.killshadow.leetcode;

public class NumSubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        System.out.println(new NumSubarrayProductLessThanK().numSubarrayProductLessThanK(nums, k));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0;
        int ans = 0;
        int mul = 1;
        for (int right = 0; right < nums.length; right++) {
            mul *= nums[right];
            while (mul >= k) {
                mul /= nums[left++];
            }
            ans += right - left + 1;
        }

        return ans;
    }

//    public int numSubarrayProductLessThanK(int[] nums, int k) {
//        if (k <= 1) return 0;
//        int prod = 1, ans = 0, left = 0;
//        for (int right = 0; right < nums.length; right++) {
//            prod *= nums[right];
//            while (prod >= k) prod /= nums[left++];
//            ans += right - left + 1;
//        }
//        return ans;
//    }
}
