package com.killshadow.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {
    public static void main(String[] args) {
        List<List<String>> res = new Partition().partition("aaba");
        res.forEach(list -> System.out.println(Arrays.toString(list.toArray())));
    }
    // 用idxTable记录对应左右指针区间内的子串是否是回文串.
    int[][] idxTable;
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> trace = new ArrayList<>();
        idxTable = new int[s.length()][s.length()];
        backtrack(res, trace, s, 0);
        return res;
    }

    /**
     * 回溯算法模板.
     *
     * @param res 最终返回的所有分割后的回文串列表.
     * @param trace 路径记录的列表.
     * @param totalStr 需要被分割的字符串.
     * @param start 左指针.
     */
    public void backtrack(List<List<String>> res, List<String> trace, String totalStr, int start) {
        // 1. 结束条件: 起始index(左边的index)为字符串的长度, 说明已经遍历到最后一个字符所在的index.
        if (totalStr.length() == start) {
            res.add(new ArrayList<>(trace));
            return;
        }

        // 2. 从起始index开始, 逐渐向有遍历查找是否有回文.
        for (int end = start; end < totalStr.length(); end++) {
            // 3. 判断是否有遍历过且确定是回文的子串, 如果是回文串, 则进一步递归.
            if (isPalindrome(totalStr, start, end) != 1) {
                continue;
            }
            // 4.1 做选择, 右指针向右移动一位.
            trace.add(totalStr.substring(start, end + 1));
            // 4.2 递归判断右指针右移一位后的子串是否是回文串.
            backtrack(res, trace, totalStr, end + 1);
            // 4.3 撤销选择
            trace.remove(trace.size() - 1);
        }
    }

    /**
     * 判断是否已经遍历过.
     *
     * @param str 需要被判断是否有子串是回文的字符串.
     * @param start 字符串开始的index.
     * @param end 字符串结束的index.
     * @return 返回是否是回文, idxTable状态有-1,0,1, 分别表示:不是回文,初始状态(还未判断是否是回文),是回文.
     */
    public int isPalindrome(String str, int start, int end) {
        // 如果不是初始化状态, 则说明已经判断过是否是回文了, 直接返回.
        if (idxTable[start][end] != 0) {
            return idxTable[start][end];
        }

        // 如果左边的index(开始index)大于等右边的index(结束index), 说明经过多次递归之后,是回文.
        // 如果start和end对应的字符是一样的,则左idx+1,右idx-1,对中间的子串再递进一步判断.
        // 否则, 判断为不是回文.
        if (start >= end) {
            idxTable[start][end] = 1;
        } else if (str.charAt(start) == str.charAt(end)) {
            idxTable[start][end] = isPalindrome(str, start + 1, end - 1);
        } else {
            idxTable[start][end] = -1;
        }
        return idxTable[start][end];
    }
}
