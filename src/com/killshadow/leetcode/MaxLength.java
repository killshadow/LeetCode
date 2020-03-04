package com.killshadow.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLength {
    public static void main(String[] args) {

    }

    public int maxLength(List<String> arr) {
//        Set<Character> pool = new HashSet<>();
//        for (String string : arr) {
//            char[] chars = string.toCharArray();
//            for (char ch : chars) {
//
//            }
//        }

        return 0;
    }

//    public int dfs(List<String> aar, int sum) {
//        if (sum == aar.size()) {
//            return sum;
//        }
//        if ()
//    }

    public boolean notEqual(String str1, String str2) {
        int[] alpha = new int[26];
        char[] char1 = str1.toCharArray();
        for (char ch1 : char1) {
            alpha[ch1 - 'a'] = 1;
        }
        char[] char2 = str2.toCharArray();
        for (char ch2 : char2) {
            if (char1[ch2 - 'a'] == 1) {
                return false;
            }
        }
        return true;
    }
}
