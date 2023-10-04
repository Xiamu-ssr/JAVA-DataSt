package org.kmo.d05_IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * File常用方法02
 * */
public class FileTest02 {
    @Test
    public void test01() throws IOException {
        //1、 public boolean createNewFile()：创建一个新文件（文件内容为空)，创建成功返回true,反之。
        File f1 = new File("src/main/resources/FileIO/2.txt");
        System.out.println(f1.createNewFile());
        //2、public boolean mkdir()：用于创建文件夹，注意：只能创建一级文件夹
        File f2 = new File("src/main/resources/FileIO/testdir01");
        System.out.println(f2.mkdir());
        //3、public boolean mkdirs（)：用于创建文件夹，注意：可以创建多级文件夹
        File f3 = new File("src/main/resources/FileIO/testdir02/dir22");
        System.out.println(f3.mkdirs());
        //4、public boolean delete()：删除文件，或者空文件，注意：不能删除非空文件夹。
        System.out.println(f1.delete());
        System.out.println(f2.delete());
        System.out.println(f3.delete());
        File f4 = new File("src/main/resources/FileIO/testdir02");
        System.out.println(f4.delete());
    }

}
