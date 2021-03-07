package com.killshadow.thinkingjava.thread;

public class Thread2 {
    public static void main(String[] args) {
        // Create two Thread objects
        Thread t1 = new Thread(Thread2::print);
        Thread t2 = new Thread(Thread2::print);

        Thread t3 = new Thread(Thread2::printSync);
        Thread t4 = new Thread(Thread2::printSync);

        Thread t5 = new Thread(Thread2::printPartSync);
        Thread t6 = new Thread(Thread2::printPartSync);

        // 多线程竞争
//        System.out.println("Start thread1.");
//        t1.start();
//        System.out.println("Start thread2.");
//        t2.start();

        // 多线程阻塞
//        t3.start();
//        t4.start();

        // 多线程方法块阻塞
        t5.start();
        t6.start();
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

    // 可以一个实例方法和一个静态方法同步。构造函数不能声明为同步。
    public static void printPartSync() {
        System.out.println("Print start");
        for (int i = 200; i <= 500; i++) {
            System.out.println(i);
        }
        synchronized (Thread2.class) {
            for (int i = 100; i <= 150; i++) {
                System.out.println(i);
            }
        }
        System.out.println("Print stop.");
    }
}
