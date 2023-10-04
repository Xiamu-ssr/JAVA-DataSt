package org.kmo.d05_IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * File常用方法03
 * */
public class FileTest03 {
    @Test
    public void test01() throws IOException {
        // 1、 public String[] list() 获取当前目录下所有的"一级文件名称"到一个字符串数组中去返回。
        File f1 = new File("src/main/resources/FileIO/FileTest03");
        String[] list = f1.list();
        System.out.println(Arrays.toString(list));
        // 2、 public File[] listFiles(): (重点)获取当前目录下所有的"一级文件对象"到一个文件对象数组中去返回(重点)
        File[] files = f1.listFiles();
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
