package com.killshadow.leetcode;

import java.util.*;

/*
 *
 * */
public class Middle {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }

            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }

            int i = k + 1;
            int j = nums.length - 1;
            int sum;
            while (i < j) {
                sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i<j && nums[i++] == nums[i]);
                } else if (sum == 0) {
                    result.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i<j && nums[i++] == nums[i]);
                    while (i<j && nums[j--] == nums[j]);
                } else {
                    while (i<j && nums[j--] == nums[j]);
                }
            }
        }
        return result;
    }
}
