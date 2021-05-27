package com.killshadow.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {
    public static void main(String[] args) {

    }
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;

        int valid = 0;

        while (right < s2.length()) {
            char rightChar = s2.charAt(right);
            if (need.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                if (need.get(rightChar).equals(window.get(rightChar))) {
                    valid++;
                }
            }
            right++;
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char leftChar = s2.charAt(left);
                if (need.containsKey(leftChar)) {
                    if (need.get(leftChar).equals(window.get(leftChar))) {
                        valid--;
                    }
                    window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
                }
                left++;
            }
        }
        return false;
    }
}
