package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public static void main(String[] args) {
//        System.out.println(letterCombinations("23"));
    }

    private static final Map<String, String> alphabetNum = new HashMap<String, String>(){{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> out = new ArrayList<>();

    public void searchWords (String nextNum, String combine) {
        if (nextNum.length() == 0) {
            out.add(combine);
        } else {
            String currentNum = nextNum.substring(0, 1);
            String currentAlpha = alphabetNum.get(currentNum);
            for (int i = 0; i < currentAlpha.length(); i++) {
                searchWords(nextNum.substring(1),
                        combine + currentAlpha.substring(i, i + 1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            searchWords(digits, "");
        }
        return out;
    }
}