package com.killshadow.leetcode;

public class MaxArea {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new MaxArea().maxArea(nums));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                maxArea = Math.max(height[left] * (right - left), maxArea);
                left++;
            } else {
                maxArea = Math.max(height[right] * (right - left), maxArea);
                right--;
            }
        }
        return maxArea;
    }
}