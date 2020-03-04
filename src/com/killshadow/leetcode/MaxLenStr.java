package com.killshadow.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxLenStr {
    // abcabcbb --> abc --> 3
    // bbbbbbb --> b --> 1
    // pwwkew --> wke --> 3
    public static void main(String[] args) {
        String str = new String();
        str = "abcabcbb";
        int out = lengthOfLongestSubstring(str);
        System.out.println(out);
    }
    //
    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int startIndex = 0;
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                startIndex = Math.max(startIndex, hashMap.get(s.charAt(i)));
            }
            hashMap.put(s.charAt(i), i + 1);
            ret = Math.max(ret, i - startIndex + 1);
        }
        return ret;
    }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int end = 0, start = 0; end < n; end++) {
                char alpha = s.charAt(end);
                if (map.containsKey(alpha)) {
                    start = Math.max(map.get(alpha), start);
                }
                ans = Math.max(ans, end - start + 1);
                map.put(s.charAt(end), end + 1);
            }
            return ans;
        }
    }

//    class Solution {
//        public int lengthOfLongestSubstring(String s) {
//            if (s.length() == 0) return 0;
//            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//            int max = 0;
//            int left = 0;
//            for (int i = 0; i < s.length(); i++) {
//                if (map.containsKey(s.charAt(i))) {
//                    left = Math.max(left, map.get(s.charAt(i)) + 1);
//                }
//                map.put(s.charAt(i), i);
//                max = Math.max(max, i - left + 1);
//            }
//            return max;
//
//        }
//    }
    /*
    * 我们定义不重复子串的开始位置为 start，结束位置为 end
随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
无论是否更新 start，都会更新其 map 数据结构和结果 ans。
*/
}
