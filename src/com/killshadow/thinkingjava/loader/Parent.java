package com.killshadow.thinkingjava.loader;

public class Parent {
    final static String tag = "male";
    static String name = "lihua";
    int flag = 50;

    static {
        System.out.println("Parent static area.");
    }

    {
        System.out.println("Parent dynamic area.");
    }

    public Parent(int flag) {
        this.flag = flag;
        System.out.println("Init parent constructor Finish.");
    }

    public String getName() {
        return name;
    }
}
