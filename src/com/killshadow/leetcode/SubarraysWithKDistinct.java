package com.killshadow.leetcode;

import java.util.Vector;

public class SubarraysWithKDistinct {
    public static void main(String[] args) {

    }

    public int subarraysWithKDistinct(int[] A, int K) {
        int ret = 0;
        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < A.length; i++) {
            vector.removeAllElements();
            for (int j = i; j < A.length; j++) {
                vector.add(A[j]);
                if (vector.contains(A[j]) == false) {
                    vector.add(A[j]);
                }
            }
        }

        return ret;
    }
}
