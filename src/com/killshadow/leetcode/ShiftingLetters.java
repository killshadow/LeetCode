package com.killshadow.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShiftingLetters {
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        ShiftingLetters shiftingLetters = new ShiftingLetters();
        Map<String, Integer[]> input = new HashMap<>();
        input.put("abc", new Integer[]{3, 5, 9});
        input.put("z", new Integer[]{52});
        input.put("mkgfzkkuxownxvfvxasy",
                new Integer[]{505870226, 437526072, 266740649, 224336793, 532917782, 311122363,
                        567754492, 595798950, 81520022, 684110326, 137742843, 275267355, 856903962,
                        148291585, 919054234, 467541837, 622939912, 116899933, 983296461, 536563513});

        for (String key : input.keySet()) {
            System.out.println(shiftingLetters.shiftingLetters(key,
                    Arrays.stream(input.get(key)).mapToInt(Integer::valueOf).toArray()));
        }
//        System.out.println(shiftingLetters.shiftingLetters());
    }
    public String shiftingLetters(String S, int[] shifts) {
        char[] shifted = new char[shifts.length];
        long[] bigNum = new long[shifts.length];
        bigNum[shifts.length - 1] = shifts[shifts.length - 1];

        for (int i = shifts.length - 2; i >= 0; i--) {
            bigNum[i] += shifts[i] + bigNum[i + 1];
            shifted[i] = (char)((bigNum[i] + (int)S.charAt(i) - 97) % 26 + 97);
        }

        shifted[shifts.length - 1] = (char)((shifts[shifts.length - 1] +
                (int)S.charAt(shifts.length - 1) - 97) % 26 + 97);
        return new String(shifted);
    }
}
