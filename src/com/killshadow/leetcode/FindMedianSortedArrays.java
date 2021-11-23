package com.killshadow.leetcode;

import java.util.Arrays;

/**
 * User: killshadow
 * Date: 2021/11/5 0005
 * Description:
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        FindMedianSortedArrays arrays = new FindMedianSortedArrays();
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        System.out.println(arrays.findMedianSortedArrays(num1, num2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len == 0) {
            return 0;
        }
        int[] array = new int[len];
        System.arraycopy(nums1, 0, array, 0, nums1.length);
        System.arraycopy(nums2, 0, array, nums1.length, nums2.length);
        Arrays.sort(array);
        double ans;
        int mid = len / 2;
        if (len % 2 == 0) {
            ans = (double) (array[mid] + array[mid - 1]) / (double) 2;
        } else {
            ans = array[mid];
        }
        return ans;
    }
}
