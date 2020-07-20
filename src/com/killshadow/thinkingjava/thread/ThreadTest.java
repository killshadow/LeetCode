package com.killshadow.thinkingjava.thread;

public class ThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("主线程开始...");
                Thread sonThread = new Thread(new Thread1(Thread.currentThread()));
                sonThread.setDaemon(false);
                sonThread.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("主线程结束");
            }
        });
        thread.start();
    }
}
