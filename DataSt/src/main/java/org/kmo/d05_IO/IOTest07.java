package org.kmo.d05_IO;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 体验IO框架
 * */

public class IOTest07 {
    private final String dirPath="src/main/resources/FileIO/IOTest07/";

    @Test
    public void test01(){
//        copy
        try {
            FileUtils.copyFile(new File(dirPath + "old/1.txt"), new File(dirPath + "new/1.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        delete
    }
}
