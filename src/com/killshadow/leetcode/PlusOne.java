package com.killshadow.leetcode;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3};
        int[] num2 = new int[]{4, 3, 2, 1};
        int[] num3 = new int[]{9, 9};
        System.out.println(Arrays.toString(new PlusOne().plusOne(num3)));

    }
//    public int[] plusOne(int[] digits) {
//        int len = digits.length;
//        int tmp = digits[len - 1] + 1;
//        int flag;
//        if (tmp < 10) {
//            flag = 0;
//            digits[len - 1] = tmp;
//        } else {
//            flag = 1;
//            digits[len - 1] = tmp % 10;
//        }
//        for (int i = digits.length - 2; i >= 0; i--) {
//            tmp = digits[i] + flag;
//            if (tmp < 10) {
//                flag = 0;
//                digits[i] = tmp;
//            } else {
//                flag = 1;
//                digits[i] = tmp % 10;
//            }
//
//        }
//        if (flag == 1) {
//            digits = new int[len + 1];
//            digits[0] = 1;
//        }
//        return digits;
//    }

    /**
     * Add one
     * @param digits input array
     * @return calculate result
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len+1];
        digits[0] = 1;
        return digits;
    }
}
