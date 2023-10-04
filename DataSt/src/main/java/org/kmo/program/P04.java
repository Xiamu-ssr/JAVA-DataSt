package org.kmo.program;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <h2>需求</h2>
 * 改变文件夹下文件的序号，从19开始
 * */

public class P04 {
    private Logger logger = LoggerFactory.getLogger("P04");
    private String dirpath = "src/main/resources/FileIO/";
    private String dirname = "P04";
    public void print(String path){
        File d1 = new File(path);
        File[] files = d1.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getPath());
            }
        }else {
            System.out.println("Null");
        }
    }
    public void init() throws IOException {
        File d1 = new File(dirpath+dirname);
        d1.mkdirs();
        for(int i=8; i<16; ++i){
            File f = new File(dirpath+dirname+"/"+i+"、哈哈.txt");
            f.createNewFile();
        }
        logger.info("旧文件如下：");
        print(dirpath+dirname);
    }
    public void clear(){
        File d1 = new File(dirpath+dirname);
        File[] files = d1.listFiles();
        for (File file : files) {
            file.delete();
        }
        d1.delete();
        logger.info("已清空，如下：");
        print(dirpath+dirname);
    }
    @Test
    public void test01() throws IOException {
        init();
        /*code*/
        File d1 = new File(dirpath+dirname);
        File[] files = d1.listFiles();
        int startNum = 19;
        for (File file : files) {
            String name = file.getName();
            String newName = startNum++ + name.substring(name.indexOf('、'));
            file.renameTo(new File(d1+"/"+newName));
        }
        /*code*/
        logger.info("新文件如下");
        print(dirpath+dirname);
        clear();
    }
}
