package com.killshadow.leetcode;

import java.util.Arrays;

/**
 * User: killshadow
 * Date: 2021/6/6 0006
 * Description:
 */
public class RemoveCoveredIntervals {
    public static void main(String[] args) {

    }

    public int removeCoveredIntervals(int[][] intervals) {
        // 1. 对各个区间进行排序: 首先, 按左边界, 从小到大排列区间; 其次, 若左边界相等, 则右边界小的排在前面.
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0]));

        int ans = 0;
        int left = intervals[0][0];
        int right = intervals[0][1];

        // 2. 从最左边的区间逐渐向最右边的区间遍历.
        for (int i = 1; i < intervals.length; i++) {
            int[] intv = intervals[i];
            // 2.1 区间完全重叠
            if ((left <= intv[0]) && (right >= intv[1])) {
                ans++;
            }
            // 2.2 区间交叉
            if ((left <= intv[0]) && (right <= intv[1])) {
                right = intv[1];
            }
            // 2.3 区间无交集
            if (right < intv[0]) {
                left = intv[0];
                right = intv[1];
            }
        }
        return intervals.length - ans;
    }
}
