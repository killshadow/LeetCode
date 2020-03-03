package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleNumber {
    public static void main(String[] args) {
        TriangleNumber triangleNumber = new TriangleNumber();
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(new Integer[]{2, 2, 3, 4}));
//        new int[]{0, 1, 1, 1}
        System.out.println(triangleNumber.triangleNumber(new int[]{1, 2, 3, 4, 5, 6}));
    }
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                count += k - j - 1;
            }
        }
        return count;
    }

//    public int triangleNumber(int[] nums) {
//        Arrays.sort(nums);
//        int sum = 0;
////        System.out.println(Arrays.toString(nums));
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                sum++;
//            } else {
//                break;
//            }
//        }
//        int[] calc = Arrays.copyOfRange(nums, sum, nums.length);
//        System.out.println(Arrays.toString(calc));
//
//        sum = 0;
//        for (int i = calc.length - 1; i > 1; i--) {
//            boolean flag = false;
//            for (int j = i - 1; j > 0; j--) {
//                for (int k = 0; k < j; k++) {
//                    if (calc[k] + calc[j] > calc[i]) {
//                        System.out.println(nums[k] + ":" + nums[j] + ":" + nums[i]);
//                        sum++;
//                    } else {
//                        flag = true;
//                    }
//                }
//                if (flag) {
//                    break;
//                }
//            }
//        }
//        return sum;
//    }
}
