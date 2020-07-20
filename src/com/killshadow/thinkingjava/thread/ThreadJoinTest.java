package com.killshadow.thinkingjava.thread;

class ThreadJoinTest extends Thread{
    public ThreadJoinTest(String name){
        super(name);
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println(this.getName() + ":" + i);
        }
    }
}
