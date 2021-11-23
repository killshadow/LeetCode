package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: killshadow
 * Date: 2021/11/13 0013
 * Description:
 */
public class LengthOfLongestSubstringKDistinct {
    public static void main(String[] args) {
        LengthOfLongestSubstringKDistinct distinct = new LengthOfLongestSubstringKDistinct();
        System.out.println(distinct.lengthOfLongestSubstringKDistinct("eceba", 2)); // 3
        System.out.println(distinct.lengthOfLongestSubstringKDistinct("aa", 1)); // 2
        System.out.println(distinct.lengthOfLongestSubstringKDistinct("ccaabbb", 3)); // 7
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
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
            while (left < right && cnt > k && !list.isEmpty()) {
                cur = list.remove(0);
                if (!list.contains(cur)) {
                    cnt--;
                }
                left++;
            }
            if (cnt <= k) {
                ans = Math.max(ans, right - left);
            }
        }
        return ans;
    }
}
