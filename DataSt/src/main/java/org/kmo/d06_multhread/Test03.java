package org.kmo.d06_multhread;


import org.junit.Test;

/**
 * 创建多线程方式2-》匿名内部类Runnable
 * */
public class Test03 {
    @Test
    public void test01(){
        Runnable target = new Runnable() {
            @Override
            public void run() {
                Thread cut = Thread.currentThread();
                for (int i = 0; i < 5; i++) {
                    System.out.println("thread ["+cut.getName()+"]"+i);
                }
            }
        };
        new Thread(target).start();

        Thread cut = Thread.currentThread();
        for (int i = 0; i < 5; i++) {
            System.out.println("thread ["+cut.getName()+"]"+i);
        }
    }
    @Test
    public void test02(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread cut = Thread.currentThread();
                for (int i = 0; i < 5; i++) {
                    System.out.println("thread ["+cut.getName()+"]"+i);
                }
            }
        }).start();

        Thread cut = Thread.currentThread();
        for (int i = 0; i < 5; i++) {
            System.out.println("thread ["+cut.getName()+"]"+i);
        }
    }
    @Test
    public void test03(){
        new Thread(()->{
            Thread cut = Thread.currentThread();
            for (int i = 0; i < 5; i++) {
                System.out.println("thread ["+cut.getName()+"]"+i);
            }
        }).start();

        Thread cut = Thread.currentThread();
        for (int i = 0; i < 5; i++) {
            System.out.println("thread ["+cut.getName()+"]"+i);
        }
    }
}
