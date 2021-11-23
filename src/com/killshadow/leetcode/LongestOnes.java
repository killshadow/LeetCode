package com.killshadow.leetcode;

/**
 * User: killshadow
 * Date: 2021/11/13 0013
 * Description:
 */
public class LongestOnes {
    public static void main(String[] args) {
        LongestOnes ones = new LongestOnes();
        System.out.println(ones.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2)); // 6
        System.out.println(ones.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 3)); // 10
        System.out.println(ones.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3)); // 10
    }

    public int longestOnes(int[] nums, int k) {
        int cnt = 0;
        int ans = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                cnt++;
            }
            right++;
            while (left < right && cnt > k) {
                if (nums[left] == 0) {
                    cnt--;
                }
                left++;
            }
            if (cnt <= k) {
                ans = Math.max(ans, right - left);
            }
        }
        return ans;
    }
}
