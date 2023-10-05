package org.kmo.d05_IO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * 学习使用try-with-resource释放资源
 * */

public class IOTest01 {
    private final String filePath = "src/main/resources/FileIO/1.txt";
    @Test
    public void test01(){
        try (FileInputStream fileInputStream = new FileInputStream(filePath);) {
            byte[] bytes = fileInputStream.readAllBytes();
            System.out.println(Arrays.toString(bytes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
