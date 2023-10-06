package org.kmo.d06_multhread;

public class Test02_01 implements Runnable{

    @Override
    public void run() {
        Thread cut = Thread.currentThread();
        for (int i = 0; i < 5; i++) {
            System.out.println("thread ["+cut.getName()+"]"+i);
        }
    }
}
