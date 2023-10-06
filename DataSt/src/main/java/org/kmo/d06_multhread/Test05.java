package org.kmo.d06_multhread;

import org.junit.Test;

/**
 * 线程常用方法
 * */
public class Test05 {

    @Test
    public void test01() throws Exception {
        Runnable r1 = new Test02_01();
        Thread t1 = new Thread(r1, "1号线程");
        t1.start();
        t1.join();


        Runnable r2 = new Test02_01();
        Thread t2 = new Thread(r2, "2号线程");
        t2.start();

        Thread tm = Thread.currentThread();
        tm.setName("主线程");
        for (int i = 0; i < 5; i++) {
            System.out.println(tm.getName()+" "+i);
        }

    }
}
