package com.killshadow.thinkingjava.thread;

public class Thread1 implements Runnable {
    private Thread mainThread;

    public Thread1(Thread thread) {
        mainThread = thread;
    }

    @Override
    public void run() {
        while (mainThread.isAlive()) {
            System.out.println("子线程运行中...");
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
