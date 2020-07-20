package com.killshadow.thinkingjava.thread;

public class Thread2 {
    public static void main(String[] args) {
        // Create two Thread objects
        Thread t1 = new Thread(Thread2::print);
        Thread t2 = new Thread(Thread2::print);

        // Start both threads
        t1.start();
        t2.start();
    }

    public static void print() {
        for (int i = 1; i <= 500; i++) {
            System.out.println(i);
        }
    }
}
