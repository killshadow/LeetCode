package com.killshadow.leetcode;

import java.util.Deque;
import java.util.LinkedList;

class MyStack {
    private Deque<Integer> normal_queue;
    private Deque<Integer> switch_queue;
    /** Initialize your data structure here. */
    public MyStack() {
        normal_queue = new LinkedList<>();
        switch_queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        switch_queue.offer(x);
        while (!normal_queue.isEmpty()) {
            switch_queue.offer(normal_queue.poll());
        }
        Deque<Integer> tmp = normal_queue;
        normal_queue = switch_queue;
        switch_queue = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return normal_queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return normal_queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return normal_queue.isEmpty();
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