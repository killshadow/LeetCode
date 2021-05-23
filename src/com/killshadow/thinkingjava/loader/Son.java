package com.killshadow.thinkingjava.loader;

public class Son extends Parent {
    final static String tag = "male";
    static String name = "lihua";
    int flag = 20;

    static {
        System.out.println("Son static area.");
    }

    {
        System.out.println("Son dynamic area.");
    }

    public Son(int flag) {
        super(flag);
        System.out.println("Init son constructor Finish.");
    }

    public String getName() {
        return name;
    }
}
