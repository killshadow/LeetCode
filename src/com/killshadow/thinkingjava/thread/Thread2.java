package com.killshadow.thinkingjava.thread;

public class Thread2 {
    public static void main(String[] args) {
        // Create two Thread objects
        Thread t1 = new Thread(Thread2::print);
        Thread t2 = new Thread(Thread2::print);

        Thread t3 = new Thread(Thread2::printSync);
        Thread t4 = new Thread(Thread2::printSync);

        // Start both threads
//        System.out.println("Start thread1.");
//        t1.start();
//        System.out.println("Start thread2.");
//        t2.start();

        t3.start();
        t4.start();
    }

    public static void print() {
        System.out.println("Print start");
        for (int i = 1; i <= 50; i++) {
            System.out.println(i);
        }
        System.out.println("Print stop.");
    }

    public static synchronized void printSync() {
        System.out.println("Print start");
        for (int i = 1; i <= 50; i++) {
            System.out.println(i);
        }
        System.out.println("Print stop.");
    }
}
