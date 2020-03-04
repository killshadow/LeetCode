package com.killshadow.leetcode;

import java.util.*;

public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(new Intersection().intersection(nums1, nums2)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        set1.retainAll(set2);
        int[] ans = new int[set1.size()];
        int idx = 0;
        for (int num: set1) {
            ans[idx++] = num;
        }
        return ans;
    }
}