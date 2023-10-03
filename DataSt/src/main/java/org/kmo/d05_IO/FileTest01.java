package org.kmo.d05_IO;

import org.junit.Test;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * File常用方法01
 * */
public class FileTest01 {
    @Test
    public void test01(){
        // 1.创建文件对象，指代某个文件
        File f1 = new File("src/main/resources/FileIO/1.txt");
        // 2. public boolean exists():判断当前文件对象,对应的文件路径是否存在，存在返回true.
        System.out.println(f1.exists());
        // 3、public boolean isFile() ： 判断当前文件对象指代的尼否足文件，足文件返回true，反之。
        System.out.println(f1.isFile());
        // 4, public boolean isDirectory() ：判断当前文件对象指代的是否是文件夹，是文件夹返回true，反之。
        System.out.println(f1.isDirectory());
        // 5.public String getName()：获取文件的名称（包含后缀)
        System.out.println(f1.getName());
        // 6.public long length：获取文件的大小，返川字节个数
        System.out.println(f1.length());
        // 7.public long lastKodified()：获取文件的最后修改时间。
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(f1.lastModified()));
        // 8.public String getPath():获取创建文件对象时,使用的路径
        System.out.println(f1.getPath());
        // 9.public String getAbsolutePath()：获取绝对路径
        System.out.println(f1.getAbsolutePath());
    }

}
