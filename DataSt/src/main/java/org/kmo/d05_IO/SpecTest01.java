package org.kmo.d05_IO;


import org.junit.Test;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * Properties文件互动
 * */
public class SpecTest01 {
    private final String filePath = "src/main/resources/FileIO/SpecTest01/users.properties";
    private final String filePath2 = "src/main/resources/FileIO/SpecTest01/users2.properties";

    public void clear(String path){
        File f = new File(path);
        f.delete();
    }

    @Test
    public void test01() throws IOException {
        //1.创建对象
        Properties properties = new Properties();
        //2.加载文件
        properties.load(new FileReader(filePath));
        //3.读取属性
        System.out.println(properties.getProperty("admin"));
        //4.遍历
        Set<String> set = properties.stringPropertyNames();
        for (String s : set) {
            String value = properties.getProperty(s);
            System.out.println(s + "-" + value);
        }
        //4.2遍历
        properties.forEach((k, v)->{
            System.out.println(k+"-"+v);
        });
    }

    @Test
    public void test02() throws Exception {
        clear(filePath2);
        Properties properties = new Properties();
        properties.setProperty("mkl", "Qv8>");
        properties.setProperty("fwj","sbsbsb");

        properties.store(new FileWriter(filePath2), "test222coment");

    }
}
