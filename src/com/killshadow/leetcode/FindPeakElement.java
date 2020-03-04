package com.killshadow.leetcode;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(new FindPeakElement().findPeakElement(nums));
    }

    /**
     * This funtion is to find out Peak Element in array.
     * @param nums input array.
     * @return Peak Element
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right) {
            mid = (right + left) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}