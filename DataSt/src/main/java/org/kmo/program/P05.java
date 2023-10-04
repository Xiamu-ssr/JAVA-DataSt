package org.kmo.program;


import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.security.PublicKey;

/**
 * <h2>需求</h2>
 * 从C盘中，搜索WeChat.exe，并输出路径，然后打开它
 * */
public class P05 {
    private boolean findFlag = false;
    @Test
    public void test01(){
        find("C:/", "WeChat.exe");
    }

    /**
     * 给定一个路径，查找路径下所有文件并对所有文件夹执行相同的操作
     * @param path 路径
     * */
    public void find(String path, String fileName){
        if (findFlag){
            return;
        }
        File f = new File(path);
        File[] files = f.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().equals(fileName)){
                    System.out.println(file.getAbsolutePath());
                    findFlag = true;
                    Runtime runtime = Runtime.getRuntime();
                    try {
                        runtime.exec(file.getAbsolutePath());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    find(file.getAbsolutePath(), fileName);
                }
            }
        }
    }
}
