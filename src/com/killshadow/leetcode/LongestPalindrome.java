package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrome {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("babad");
        strings.add("bb");
        strings.add("abcba");
        for (String string : strings) {
            System.out.println(new LongestPalindrome().longestPalindrome(string));
        }
    }

    /**
     * Find out longest Palindrome, such as "abcdcba"
     * @param string input String
     * @return longest palindrome
     */
    public String longestPalindrome(String string) {
        int len = string.length();
        if (len == 1) {
            return string;
        }
        int max = 0;
        String ans = "";
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String tmp = string.substring(i, j);
                if (tmp.length() > max && isPalindrome(tmp)) {
                    ans = tmp;
                    max = ans.length();
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String string) {
        char[] chars = string.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - i - 1]) {
                return false;
            }
        }
        return true;
    }
}