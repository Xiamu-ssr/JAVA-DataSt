package org.kmo.d06_multhread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * <p>线程池处理Callable任务</p>
 * */

public class ThreadPool02 {

    private static class MyCallable implements Callable<String> {
        private int num;

        public MyCallable(int num) {
            this.num = num;
        }

        @Override
        public String call() throws Exception {
            int sum = 0;
            for (int i = 0; i < num; i++) {
                sum += i+1;
            }
            return "线程"+Thread.currentThread().getName()+" 计算出了结果为："+sum;
        }
    }

    public static void main(String[] args) throws Exception {
        //1.create threadpool object
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 5, 8, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        List<Future<String>> listF = new ArrayList<>();
        listF.add(threadPool.submit(new MyCallable(80)));// core 1
        listF.add(threadPool.submit(new MyCallable(100)));// core 2
        listF.add(threadPool.submit(new MyCallable(30)));// core 3
        listF.add(threadPool.submit(new MyCallable(40)));// wait 1
        listF.add(threadPool.submit(new MyCallable(100)));// wait 2
        listF.add(threadPool.submit(new MyCallable(40)));// wait 3
        listF.add(threadPool.submit(new MyCallable(50)));// wait 4
        listF.add(threadPool.submit(new MyCallable(200)));// temp 1
        listF.add(threadPool.submit(new MyCallable(50)));// temp 2
        listF.add(threadPool.submit(new MyCallable(50)));// main

        for (Future<String> f : listF) {
            System.out.println(f.get());
        }

        threadPool.shutdown();
    }
}
