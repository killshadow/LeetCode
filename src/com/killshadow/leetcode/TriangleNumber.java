package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleNumber {
    public static void main(String[] args) {
        TriangleNumber triangleNumber = new TriangleNumber();
        List<Integer[]> input = new ArrayList<>();
        input.add(new Integer[]{2, 2, 3, 4});
        input.add(new Integer[]{0, 1, 1, 1});
        input.add(new Integer[]{1, 2, 3, 4, 5, 6});
        for (Integer[] in : input) {
            System.out.println(triangleNumber.triangleNumber(
                    Arrays.stream(in).mapToInt(Integer::valueOf).toArray()));
        }
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
//        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum++;
            } else {
                break;
            }
        }
        int[] calc = Arrays.copyOfRange(nums, sum, nums.length);
//        System.out.println(Arrays.toString(calc));
        sum = 0;
        for (int i = calc.length - 1; i > 1; i--) {
            boolean flag = false;
            for (int j = i - 1; j > 0; j--) {
                for (int k = 0; k < j; k++) {
                    if (calc[k] + calc[j] > calc[i]) {
//                        System.out.println(nums[i] + ":" + nums[j] + ":" + nums[k]);
                        sum++;
                    } else {
                        flag = false;
                    }
                }
            }
            if (flag) {
                break;
            }
        }
        return sum;
    }
}
