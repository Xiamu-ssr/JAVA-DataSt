package org.kmo.program;


import org.junit.Test;

import java.io.*;

/**
 * <h2>需求</h2>
 * 使用字节输入输出流完成复制文件操作
 * */
public class P07 {
    private final String picDirPath = "src/main/resources/FileIO/P07/";
    private final String picName = "1.png";

    /**
     * 提供新文件名，复制到图片同一文件夹下
     * @param newName
     * */
    public void copy(String newName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(picDirPath + picName);
        byte[] bytes = fileInputStream.readAllBytes();
        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(picDirPath + newName);
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

    public void delete(String newName){
        File file = new File(picDirPath + newName);
        file.delete();
    }

    @Test
    public void test() throws IOException {
//        copy("new.png");
        delete("new.png");
    }
}
