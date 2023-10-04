package org.kmo.program;


import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * <h2>需求</h2>
 * 递归删除非空文件夹
 * */
public class P06 {
    private final String dirPath = "src/main/resources/FileIO/P06/";
    public void init(String path){
        File dir = new File(path);
        if (!dir.exists()){
            dir.mkdirs();
        }
        for(int i=0; i<8; ++i){
            File f = new File(path + i + ".txt");
            if (!f.exists()){
                try {
                    f.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 给定一个文件夹path，删除其全部内容，包括文件夹本身
     * @param path String
     * */
    public void clear(String path){
        File dir = new File(path);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()){
                    System.out.println("删除文件:"+file.getAbsolutePath());
                    file.delete();
                }else {
                    clear(file.getAbsolutePath());
                }
            }
        }
        System.out.println("删除文件夹:"+dir.getAbsolutePath());
        dir.delete();
    }
    @Test
    public void test01(){
        init(dirPath);
        init(dirPath+"P66/");
        clear(dirPath);
    }
}
