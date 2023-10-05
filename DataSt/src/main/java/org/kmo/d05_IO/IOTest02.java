package org.kmo.d05_IO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * 字符流
 * */

public class IOTest02 {
    private final String filePath = "src/main/resources/FileIO/1.txt";
    @Test
    public void test01(){
        try (FileReader fr = new FileReader(filePath);){
            int c;
            while ((c = fr.read()) !=-1){
                System.out.print((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void test02(){
        try (FileReader fr = new FileReader(filePath);){
            int len;
            char[] ch = new char[8];
            while ((len = fr.read(ch)) !=-1){
                System.out.print(new String(ch,0,len));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
