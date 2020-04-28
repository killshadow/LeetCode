package com.killshadow.test;

import javax.swing.*;

public class Animal {
    String name;
    static int age;
    int wight;
    {
        System.out.println("Dynamic init");
        name = "null";
        wight = 100;
    }
    static {
        System.out.println("Static init");
        age = 10;
    }
    public Animal() {
        System.out.println("Init Animal!");
    }
    void action() {
        System.out.println("Animal action().");
    }

    static void print(String... strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        Animal animal1 = new Animal();
        System.out.println("--->Finish new animal1<---");
        Animal animal2 = new Animal();
        System.out.println("--->Finish new animal2<---");

        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2;
        a2 = a1;
        for (int i = 0; i < a2.length; i++) {
            a2[i]++;
        }
        for (int i = 0; i < a1.length; i++) {
            System.out.println("a1[" + i + "] = " + a1[i]);
        }

        print("aaa", "bbb", "ccc");
    }
}
