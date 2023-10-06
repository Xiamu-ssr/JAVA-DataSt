package org.kmo.d06_multhread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 多线程创建方式03-》实现Callable接口
 * */
public class Test04 {
    private static class Test04_01 implements Callable<Long>{
        private int start,end,times;

        public Test04_01(int start, int end, int times) {
            this.start = start;
            this.end = end;
            this.times = times;
        }

        @Override
        public Long call() throws Exception {
            Thread cut = Thread.currentThread();
            System.out.println("当前线程:"+cut.getName());
            long res = 0;
            for (int i = 0; i < times; i++) {
                for (int j = start; j < end; j++) {
                    res += j;
                }
            }
            return res;
        }
    };

    @Test
    public void test01() throws Exception {
        //1.create object with Callable infer
        Callable<Long> call = new Test04_01(0, 100, 100);
        //2.package into FutureTask
        FutureTask<Long> task = new FutureTask<>(call);
        //3.new thread
        new Thread(task).start();
        //4.get result
        Long l = task.get();
        System.out.println(l);
    }
}
