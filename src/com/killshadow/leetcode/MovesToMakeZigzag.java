package com.killshadow.leetcode;

public class MovesToMakeZigzag {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 6, 1, 6, 2};
        int[] num = new int[]{7, 4, 8, 9, 7, 7, 5};
        int[] nums1 = new int[]{2, 7, 10, 9, 8, 9};
        System.out.println(new MovesToMakeZigzag().movesToMakeZigzag(nums1));
    }

    public int movesToMakeZigzag(int[] nums) {
        // 初始化奇偶数减小量
        int odd = 0;
        int even = 0;
        int len = nums.length;
        int left;
        int right;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                // 奇数成锯齿状时, 看偶数, 取差值+1的最大值
                left = (i > 0) && (nums[i] >= nums[i - 1]) ? (nums[i] - nums[i - 1] + 1) : 0;
                right = (i < (len - 1)) && (nums[i] >= nums[i + 1]) ? (nums[i] - nums[i + 1] + 1) : 0;
                even += Math.max(left, right);
            } else {
                // 偶数成锯齿状时, 看奇数, 取差值+1的最大值
                left = nums[i] >= nums[i - 1] ? (nums[i] - nums[i - 1] + 1) : 0;
                right = (i < (len - 1)) && (nums[i] >= nums[i + 1]) ? (nums[i] - nums[i + 1] + 1) : 0;
                odd += Math.max(left, right);
            }
        }
        return Math.min(even, odd);
    }
}