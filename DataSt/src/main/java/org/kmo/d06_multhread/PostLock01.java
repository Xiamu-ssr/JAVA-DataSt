package org.kmo.d06_multhread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>悲观锁。乐观锁</p>
 * <p>目标：拓展悲观锁，乐观锁原理。</p>
 * <p>悲观锁:一上来就加锁，没有安全感。每次只能一个线程进入访问完毕后,再解锁。线程安全，性能较差！</p>
 * <p>乐观锁：一开始不上锁，认为是没有问题的，大家一起跑，等要出现线程安全问题的时候才开始控制。线程安全,性能较好。</p>
 * */
public class PostLock01 {
    private static class MyRunnable01 implements Runnable{
        private int number;
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                synchronized (this){
                    ++number;
                }
            }
        }
    };
    private static class MyRunnable02 implements Runnable{
//        private int number;
        private AtomicInteger number = new AtomicInteger();
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                number.incrementAndGet();
            }
        }
    };

    public static void main(String[] args) {
        long timeStart, timeEnd;
        timeStart = System.currentTimeMillis();
        pessLock();
        timeEnd = System.currentTimeMillis();
        System.out.println("pessimism : "+(timeEnd - timeStart)+" ms");

        timeStart = System.currentTimeMillis();
        optiLock();
        timeEnd = System.currentTimeMillis();
        System.out.println("optimism : "+(timeEnd - timeStart)+" ms");
    }

    public static void pessLock(){
        Runnable target = new MyRunnable01();
        for (int i = 0; i < 32; i++) {
            new Thread(target).start();
        }
    }

    public static void optiLock(){
        Runnable target = new MyRunnable02();
        for (int i = 0; i < 32; i++) {
            new Thread(target).start();
        }
    }

}
