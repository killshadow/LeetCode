package com.killshadow.leetcode;

public class StrStr {
    public static void main(String[] args) {

    }

    public int strStr(String S, String T) {
        int n1 = S.length();
        int n2 = T.length();
        if (n1 < n2) return -1;
        else if ( n2 == 0) return 0;
        for (int i = 0; i < n1 - n2 + 1; i++ ){
            if (S.substring(i, i+n2).equals(T)) return i;
        }
        return -1;
    }
}
