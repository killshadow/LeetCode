package com.killshadow.leetcode;

import java.util.Stack;

class MinRemoveToMakeValid {
    public static void main(String[] args) {
        MinRemoveToMakeValid valid = new MinRemoveToMakeValid();
        System.out.println(valid.minRemoveToMakeValid1("lee(t(c)o)de)"));
        System.out.println(valid.minRemoveToMakeValid1("a)b(c)d"));
        System.out.println(valid.minRemoveToMakeValid1("))(("));
        System.out.println(valid.minRemoveToMakeValid1("(a(b(c)d)"));
    }
    public String minRemoveToMakeValid(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == '(') {
                left++;
            } else if (s.charAt(right) == ')') {
                right--;
            } else {
                right--;
                left++;
            }

            if (s.charAt(left) == ')') {
                s = cutBracket(s, left);
                right--;
                continue;
            }
            if (s.charAt(right) == '(') {
                s = cutBracket(s, right);
                right--;
                continue;
            }

        }
        return s;
    }
// ))(( 会出现数组越界
    public String cutBracket(String str, int index) {
        return str.substring(0, index) + str.substring(index + 1, str.length());
    }

    public String minRemoveToMakeValid1(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            }
            ans.append(ch);
        }
        if (stack.isEmpty()) {
            return ans.toString();
        }
        stack.clear();
        String s1 = ans.toString().intern();
        ans = new StringBuilder();
        for (int i = s1.length() - 1; i >= 0; i--) {
            char ch = s1.charAt(i);
            if (ch == ')') {
                stack.push(ch);
            } else if (ch == '(') {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            }
            ans.insert(0, ch);
        }
        return ans.toString();
    }
}