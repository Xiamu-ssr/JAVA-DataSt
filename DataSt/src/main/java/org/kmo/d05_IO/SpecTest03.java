package org.kmo.d05_IO;


import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

/**
 * 熟悉Logback
 * */

public class SpecTest03 {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger("");
    public static void main(String[] args) {
        try {
            LOGGER.info("除法开始");
            chu(10, 0);
            LOGGER.info("执行成功");
        }catch (Exception e){
            LOGGER.error("除法执行错误");
        }
    }
    public static void chu(int a, int b){
        LOGGER.debug("参数a:"+a);
        LOGGER.debug("参数b:"+b);
        int c = a/b;
        LOGGER.info("结果是："+c);
    }
}
