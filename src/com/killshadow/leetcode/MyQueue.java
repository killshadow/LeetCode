package com.killshadow.leetcode;

import java.util.Stack;

/**
 * User: killshadow
 * Date: 2021/9/27 0027
 * Description:
 */
class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> bak_stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        bak_stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack.isEmpty()) {
            bak_stack.push(stack.pop());
        }
        stack.push(x);
        while (!bak_stack.isEmpty()) {
            stack.push(bak_stack.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
