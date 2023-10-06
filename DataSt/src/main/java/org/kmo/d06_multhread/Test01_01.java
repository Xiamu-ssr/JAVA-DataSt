package org.kmo.d06_multhread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//1.subclass extends Thread Class
public class Test01_01 extends Thread{
    private Logger logger;

    public Test01_01(Logger logger) {
        this.logger = logger;
    }
    //2.override run func
    @Override
    public void run() {
        super.run();
        //3.work
        for (int i = 0; i < 5; i++) {
            logger.info("thread sout:"+i);
        }
    }
}
