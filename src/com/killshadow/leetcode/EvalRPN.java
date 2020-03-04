package com.killshadow.leetcode;

import com.killshadow.utils.MyArray;

import java.util.Stack;

public class EvalRPN {
    public static void main(String[] args) {
        System.out.println(new EvalRPN().evalRPN(MyArray.stringToStringArray("[\"4\", \"13\", \"5\", \"/\", \"+\"]")));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String ch : tokens) {
            switch (ch) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int num = stack.pop();
                    stack.push(stack.pop() / num);
                    break;
                default:
                    stack.push(Integer.valueOf(ch));
                    break;
            }
        }
        return stack.pop();
    }
}