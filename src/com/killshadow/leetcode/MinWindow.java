package com.killshadow.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public static void main(String[] args) {

    }
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        // 滑动窗口左右index
        int left = 0;
        int right = 0;

        // 记录符合条件的字符数
        int valid = 0;
        // 记录最短字串的起始index
        int start = 0;
        // 记录最短子串的结束index
        int end = Integer.MAX_VALUE;

        // 当右指针小于源字符串长度时, 可以继续往右移
        while (right < s.length()) {
            // 取出滑动窗口右边的字符
            char rightChar = s.charAt(right);
            // 当右边字符满足所需字符, 则更新window的值以及符合的字符数
            if (need.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                if (window.get(rightChar).equals(need.get(rightChar))) {
                    valid++;
                }
            }
            // 更新右指针
            right++;

            // 当滑动窗口里的的字符都满足目标子串里所有的字符, 可以移动左指针
            while (valid == need.size()) {
                // 如果滑动窗口的len小于最小子串的len, 则更新最小子串的start和end
                if (right - left < end - start) {
                    start = left;
                    end = right;
                }
                // 取出滑动窗口左边的字符
                char leftChar = s.charAt(left);
                // 当左边字符满足所需字符, 则回撤更新, 这一步骤跟右边添加字符的操作是对称的.
                if (need.containsKey(leftChar)) {
                    if (window.get(leftChar).equals(need.get(leftChar))) {
                        valid--;
                    }
                    window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
                }
                // 更新左指针
                left++;
            }
        }

        return end == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
}
