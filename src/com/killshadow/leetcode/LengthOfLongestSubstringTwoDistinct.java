package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: killshadow
 * Date: 2021/11/13 0013
 * Description:
 */
public class LengthOfLongestSubstringTwoDistinct {
    public static void main(String[] args) {
        LengthOfLongestSubstringTwoDistinct distinct = new LengthOfLongestSubstringTwoDistinct();
        System.out.println(distinct.lengthOfLongestSubstringTwoDistinct("eceba")); // 3
        System.out.println(distinct.lengthOfLongestSubstringTwoDistinct("ccaabbb")); // 5
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0;
        List<Character> list = new ArrayList<>();
        int ans = 0;
        int cnt = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            if (!list.contains(cur)) {
                cnt++;
            }
            list.add(cur);
            right++;
            while (left < right && cnt > 2 && !list.isEmpty()) {
                cur = list.remove(0);
                if (!list.contains(cur)) {
                    cnt--;
                }
                left++;
            }
            if (cnt <= 2) {
                ans = Math.max(ans, right - left);
            }
        }
        return ans;
    }
}
