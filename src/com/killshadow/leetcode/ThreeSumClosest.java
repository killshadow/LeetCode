package com.killshadow.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        int[] num2 = new int[]{0, 2, 1, -3};
        System.out.println(new ThreeSumClosest().threeSumClosest(num2, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
