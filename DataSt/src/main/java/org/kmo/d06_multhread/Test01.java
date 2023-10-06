package org.kmo.d06_multhread;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 创建线程方式01 -》
 * 继承Thread类
 * */

public class Test01 {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Test
    public void test01() {
        //4.create object
        logger.info("thread create");
        Thread t = new Test01_01(logger);
        //5.start thread
        logger.info("thread start");
        t.start();
        for (int i = 0; i < 5; i++) {
            logger.info("main:"+i);
        }
    }
}
