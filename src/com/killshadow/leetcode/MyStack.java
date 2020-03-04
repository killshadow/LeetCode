package com.killshadow.leetcode;

import java.util.Stack;

class MyStack {

    Stack<Integer> stack;
    /** Initialize your data structure here. */
    public MyStack() {
        stack = new Stack();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the top element. */
    public int top() {
        return stack.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */