package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: killshadow
 * Date: 2021/11/12 0012
 * Description:
 */
public class FindRLEArray {
    public static void main(String[] args) {

    }

    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        int idx1 = 0;
        int idx2 = 0;

        List<List<Integer>> ans = new ArrayList<>();
        while (idx1 < encoded1.length && idx2 < encoded2.length) {
            int[] mtx1 = encoded1[idx1];
            int[] mtx2 = encoded2[idx2];
            int minLen = Math.min(mtx1[1], mtx2[1]);
            encoded1[idx1][1] -= minLen;
            encoded2[idx2][1] -= minLen;

            if (encoded1[idx1][1] == 0) {
                idx1++;
            }
            if (encoded2[idx2][1] == 0) {
                idx2++;
            }

            int cur = mtx1[0] * mtx2[0];
            if (!ans.isEmpty() && cur == ans.get(ans.size() - 1).get(0)) {
                int val = ans.get(ans.size() - 1).get(1);
                ans.get(ans.size() - 1).set(1, val + minLen);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(cur);
                list.add(minLen);
                ans.add(list);
            }
        }
        return ans;
    }
}
