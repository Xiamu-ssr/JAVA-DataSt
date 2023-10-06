package org.kmo.d06_multhread;

import org.junit.Test;

/**
 * 创建多线程方式02-》实现Runable接口
 * */

public class Test02 {

    @Test
    public void test01(){
        Runnable target = new Test02_01();
        new Thread(target).start();

        Thread cut = Thread.currentThread();
        for (int i = 0; i < 5; i++) {
            System.out.println("thread ["+cut.getName()+"]"+i);
        }
    }
}
