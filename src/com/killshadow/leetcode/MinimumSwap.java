package com.killshadow.leetcode;

import javax.naming.Context;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwap {
    public static void main(String[] args) {
        Map<String, String> input = new HashMap<>();
        MinimumSwap minimumSwap = new MinimumSwap();
        input.put("xx", "yy");
        input.put("xy", "yx");
        input.put("xxyyxyxyxx", "xyyxyxxxyx");
        for (Map.Entry<String, String> in : input.entrySet()) {
            System.out.println(minimumSwap.minimumSwap(in.getKey(), in.getValue()));
        }
    }

    public int minimumSwap(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int xy = 0;
        int yx = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (chars1[i] == chars2[i]) {
                continue;
            } else if (chars1[i] == 'x') {
                xy++;
            } else {
                yx++;
            }
        }
        // 如果为xy<->xy或者yx<->yx, 则需要一次交换即可
        int ans = xy / 2 + yx / 2;
        // 剩下的xy<->yx则需要两次交换才可以, 如果xy<->yx等于0, 则不需要交换即xy+yx=0
        // 否则, xy<->yx各一对, 则需要交换两次, 即xy+yx=2
        // 如果, xy<->yx只有其中一对, 则无法组合, 返回-1
        xy %= 2;
        yx %= 2;
        return (xy + yx) == 1 ? -1 : ans + xy + yx;
    }
}
