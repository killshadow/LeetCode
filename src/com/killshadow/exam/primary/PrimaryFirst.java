package com.killshadow.exam.primary;

public class PrimaryFirst {
    public static void main(String[] args) {
        String buttons = "zyxwvutsrqponmlkjihgfedcba";
        String word = "xyz";
        System.out.println(new PrimaryFirst().testButtons(buttons, word));
    }

    /**
     * Calculate test Button length
     * @param buttons total button
     * @param word need to be match words
     * @return the length between words
     */
    public int testButtons(String buttons, String word) {
        char[] wordCh = word.toCharArray();
        char[] buttonCh = buttons.toCharArray();
        int ans = 0;
        int oldIdx = 0;
        for (int i = 0; i < wordCh.length; i++) {
            int idx = 0;
            while (true) {
                if (wordCh[i] == buttonCh[idx]) {
                    ans += Math.abs(idx - oldIdx);
                    oldIdx = idx;
                    break;
                } else {
                    idx++;
                    idx %= 26;
                }
            }
        }
        return ans;
    }
}
