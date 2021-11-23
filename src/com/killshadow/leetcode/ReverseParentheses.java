package com.killshadow.leetcode;

import java.util.*;

/**
 * User: killshadow
 * Date: 2021/11/7 0007
 * Description:
 */
public class ReverseParentheses {
    public static void main(String[] args) {
        ReverseParentheses parentheses = new ReverseParentheses();
//        System.out.println(parentheses.reverseParentheses("(abcd)"));
//        System.out.println(parentheses.reverseParentheses("(u(love)i)"));
//        System.out.println(parentheses.reverseParentheses("(ed(et(oc))el)"));
            System.out.println(parentheses.reverseParentheses("a(bcdefghijkl(mno)p)q"));
            System.out.println(parentheses.reverseParentheses2("a(bcdefghijkl(mno)p)q"));
    }

    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.delete(0, sb.length());
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public String reverseParentheses2(String s) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                int pre = stack.pop();
                map.put(pre, i);
                map.put(i, pre);
            }
        }

        StringBuilder sb = new StringBuilder();
        int direct = 1;
        for (int i = 0; i < s.length(); i += direct) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == ')') {
                i = map.get(i);
                direct = -direct;
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
