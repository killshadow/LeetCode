package com.killshadow.leetcode;

import java.util.Arrays;

/**
 * User: killshadow
 * Date: 2021/10/24 0024
 * Description:
 */
public class FindContentChildren {
    public static void main(String[] args) {
        FindContentChildren contentChildren = new FindContentChildren();
        System.out.println(contentChildren.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(contentChildren.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        System.out.println(contentChildren.findContentChildren(new int[]{1, 2, 3}, new int[]{3}));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int ans = 0;
        for (int i = 0; i < g.length; i++) {
            while (j < s.length) {
                if (g[i] <= s[j]) {
                    ans++;
                    j++;
                    break;
                }
                j++;
            }
        }
        return ans;
    }
}
