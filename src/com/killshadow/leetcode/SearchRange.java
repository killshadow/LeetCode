package com.killshadow.leetcode;

public class SearchRange {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        boolean isValidRange = left <= right && left >= 0 && right < nums.length &&
                nums[left] == target && nums[right] == target;
        return isValidRange ? new int[]{left, right} : new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean isLeftBound) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                if (isLeftBound) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return isLeftBound ? left : right;
    }
}
