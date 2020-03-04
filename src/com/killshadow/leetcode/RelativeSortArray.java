package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RelativeSortArray {
    public static void main(String[] args) {
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(relativeSortArray.relativeSortArray(arr1, arr2)));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
//        int[] ret = new int[arr1.length];
        List<Integer> copyArr1 = new ArrayList<>();
        for (int a : arr1) {
            copyArr1.add(a);
        }
        List<Integer> ret = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    ret.add(arr1[i]);
                    copyArr1.remove(i);
                }
            }
        }
        Collections.sort(copyArr1);
        ret.addAll(copyArr1);
        for (int i = 0; i < ret.size(); i++) {
            arr1[i] = ret.get(i);
        }
        return arr1;
    }
}
