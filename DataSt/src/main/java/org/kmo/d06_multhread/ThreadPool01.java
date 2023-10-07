package org.kmo.d06_multhread;

import java.util.concurrent.*;

/**
 * <p>线程池处理Runnable任务</p>
 * */

public class ThreadPool01 {

    private static class MyRunnable implements Runnable{

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + " : 666");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        //1.create threadpool object
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 5, 8, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        Runnable target1 = new MyRunnable();
        threadPool.execute(target1);// core 1
        threadPool.execute(target1);// core 2
        threadPool.execute(target1);// core 3
        threadPool.execute(target1);// wait 1
        threadPool.execute(target1);// wait 2
        threadPool.execute(target1);// wait 3
        threadPool.execute(target1);// wait 4
        threadPool.execute(target1);// temp 1
        threadPool.execute(target1);// temp 2
        threadPool.execute(target1);// reject

        threadPool.shutdown();
    }
}
