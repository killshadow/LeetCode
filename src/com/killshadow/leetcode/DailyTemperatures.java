package com.killshadow.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * User: killshadow
 * Date: 2021/6/4 0004
 * Description: 单调栈+保存Index
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures temperatures = new DailyTemperatures();
        int[] tem = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(temperatures.dailyTemperatures(tem)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int len = temperatures.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]) {
                ans[stack.peekLast()] = i - stack.pollLast();
            }
            stack.offerLast(i);
        }
        return ans;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        int left = 0;
        int right = left + 1;
        while (left < right && right < len) {
            while (right < len && temperatures[left] >= temperatures[right]) {
                right++;
            }
            if (right == len) {
                ans[left] = 0;
            } else {
                ans[left] = right - left;
            }
            left++;
            right = left + 1;
        }
        return ans;
    }
}
