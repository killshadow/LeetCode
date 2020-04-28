package com.killshadow.thinkingjava.collections;

import com.killshadow.thinkingjava.typeinfo.pets.*;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Pet> stack = new Stack<>();
        stack.addAll(Pets.list(4));
        System.out.println("Generate pets: "+stack);
        System.out.println("stack.pop: " + stack.pop());
        System.out.println("stack.peek: " + stack.peek());
        System.out.println("stack.peek after: " + stack);
        System.out.println("stack.firstElement: " + stack.firstElement());
        System.out.println("stack.lastElement: " + stack.lastElement());
        stack.push(new EgyptianMau());
        System.out.println("stack.push after: " + stack);
        stack.add(new Pug());
        System.out.println("stack.push after: " + stack);
        Pet manx = stack.get(1);
        System.out.println("stack.get(1): " + manx);
        System.out.println("stack.elementAt(1): " + stack.elementAt(1));
        System.out.println("stack.search: " + stack.search(manx));
        stack.set(1, new Dog());
        System.out.println("stack.set(1, new Dog()): " + stack);

    }
}
