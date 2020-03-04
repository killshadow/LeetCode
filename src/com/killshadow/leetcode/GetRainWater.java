package com.killshadow.leetcode;

public class GetRainWater {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        int[] left = new int[height.length];
        for (int i = 1; i < left.length; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }

        int[] right = new int[height.length];
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }

        int trapSum = 0;
        for (int i = 0; i < height.length; i++) {
//            int level = Math.min(left[i], right[i]);
            trapSum += Math.max(0, Math.min(left[i], right[i]) - height[i]);
        }
        return trapSum;
    }
}