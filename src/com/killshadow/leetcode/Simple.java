package com.killshadow.leetcode;

import java.util.HashMap;

public class Simple {

    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j=0; j < nums.length; j++) {
//                if (i != j && (nums[i] + nums[j]) == target) {
//                    return new int[]{nums[i], nums[j]};
//                }
//            }
//        }
//        return new int[]{0};
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return new int[]{i, hashMap.get(nums[i])};
            }
            hashMap.put(target - nums[i], i);
        }
        return new int[]{0};
    }
}
