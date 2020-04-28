package com.killshadow.thinkingjava.collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack<T> {
    private Deque<T> storage = new ArrayDeque<>();
    public void push(T v) { storage.push(v); }
    public T peek() { return storage.peek(); }
    public T pop() { return storage.pop(); }
    public boolean isEmpty() { return storage.isEmpty(); }
    @Override
    public String toString() {
        return storage.toString();
    }
}
