package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
    public static void main(String[] args) {

    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for (char ch : p.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;

        int valid = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (need.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                if (need.get(rightChar).equals(window.get(rightChar))) {
                    valid++;
                }
            }
            right++;

            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                char leftChar = s.charAt(left);
                if (need.containsKey(leftChar)) {
                    if (need.get(leftChar).equals(window.get(leftChar))) {
                        valid--;
                    }
                    window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
                }
                left++;
            }
        }
        return res;
    }
}