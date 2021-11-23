package com.killshadow.leetcode;

import java.util.Stack;

/**
 * User: killshadow
 * Date: 2021/9/23 0023
 * Description:
 */
class CQueue {
    Stack<Integer> stack;
    Stack<Integer> stack_bak;
    public CQueue() {
        stack = new Stack<>();
        stack_bak = new Stack<>();
    }

    public void appendTail(int value) {
        stack_bak.push(value);
        while (!stack.isEmpty()) {
            stack_bak.push(stack.pop());
        }
        Stack<Integer> tmp = stack;
        stack = stack_bak;
        stack_bak = tmp;
    }

    public int deleteHead() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
