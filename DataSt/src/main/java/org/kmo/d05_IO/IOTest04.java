package org.kmo.d05_IO;

import org.junit.Test;

import java.io.*;

/**
 * 打印流的重定向
 * */
public class IOTest04 {
    private final String outPath = "src/main/resources/FileIO/IOTest04/1.txt";

    @Test
    public void test01(){
        System.out.println("老骥伏枥");
        System.out.println("志在千里");

        try (
                PrintStream pw = new PrintStream(new FileOutputStream(outPath,true));
                ){
            System.setOut(pw);
            System.out.println("烈士暮年");
            System.out.println("壮心不已");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
