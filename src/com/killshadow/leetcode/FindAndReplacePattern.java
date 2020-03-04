package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAndReplacePattern {
    public static void main(String[] args) {

    }
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        HashMap<Character, Character> map1;
        HashMap<Character, Character> map2;
        List<String> ans = new ArrayList<>();
        char[] pat = pattern.toCharArray();
        for (String word : words) {
            char[] chr = word.toCharArray();
            boolean isMatch = true;
            map1 = new HashMap<>();
            map2 = new HashMap<>();
            for (int i = 0; i < pattern.length(); i++) {
                if (!map1.containsKey(chr[i])) {
                    map1.put(chr[i], pat[i]);
                }
                if (!map2.containsKey(pat[i])) {
                    map2.put(pat[i], chr[i]);
                }
                if (map1.get(chr[i]) != pat[i] || map2.get(pat[i]) != chr[i]) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                ans.add(word);
            }
        }
        return ans;
    }
}