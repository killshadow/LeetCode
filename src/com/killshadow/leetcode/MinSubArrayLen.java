package com.killshadow.leetcode;

public class MinSubArrayLen {
    public static void main(String[] args) {
        int s = 7;
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(s, nums));
    }
    public static int minSubArrayLen(int s, int[] nums) {
        int sum, cnt, ret = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            cnt = 0;
            for (int j = i; j < nums.length; j++) {
//                for (int k = j; k <)
                sum += nums[j];
                cnt++;
                if (sum >= s) {
                    if (ret == 0) {
                        ret = cnt;
                    }
                    ret = Math.min(cnt, ret);
                    break;
                }
            }
        }
        return ret;
    }
}
