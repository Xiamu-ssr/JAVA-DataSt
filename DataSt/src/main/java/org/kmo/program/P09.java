package org.kmo.program;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * <h2>需求</h2>
 * 测试原始字节流和高级字节流的性能<br>
 * 对一个视频进行复制
 * */

public class P09 {
    private Logger logger = LoggerFactory.getLogger("");
    private final String inPath = "src/main/resources/FileIO/P09/test.zip";
    private final String outPath = "src/main/resources/FileIO/P09/new.zip";

    public void clear(String path){
        File file = new File(path);
        file.delete();
    }

    /**
     * 原始流单字节复制
     * */
    public void copy01(){
        try (
                FileInputStream is = new FileInputStream(inPath);
                FileOutputStream os = new FileOutputStream(outPath);
                ) {
            int b;
            while ((b=is.read())!=-1){
                os.write(b);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 原始流多字节复制
     * */
    public void copy02(){
        try (
                FileInputStream is = new FileInputStream(inPath);
                FileOutputStream os = new FileOutputStream(outPath);
        ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len=is.read(bytes))!=-1){
                os.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 高级流单字节复制
     * */
    public void copy03(){
        try (
                FileInputStream is = new FileInputStream(inPath);
                BufferedInputStream bis = new BufferedInputStream(is);

                FileOutputStream os = new FileOutputStream(outPath);
                BufferedOutputStream bos = new BufferedOutputStream(os);
        ) {
            int b;
            while ((b=bis.read())!=-1){
                bos.write(b);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 高级流多字节复制
     * */
    public void copy04(){
        try (
                FileInputStream is = new FileInputStream(inPath);
                BufferedInputStream bis = new BufferedInputStream(is);

                FileOutputStream os = new FileOutputStream(outPath);
                BufferedOutputStream bos = new BufferedOutputStream(os);
        ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len=bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test01(){
        long startTime, endTime;

//        clear(outPath);
//        startTime = System.currentTimeMillis();
//        copy01();
//        endTime = System.currentTimeMillis();
//        logger.info("原始流单字节复制时长："+(endTime-startTime)+" ms");

        clear(outPath);
        startTime = System.currentTimeMillis();
        copy02();
        endTime = System.currentTimeMillis();
        logger.info("原始流多字节复制时长："+(endTime-startTime)+" ms");

        clear(outPath);
        startTime = System.currentTimeMillis();
        copy03();
        endTime = System.currentTimeMillis();
        logger.info("高级流单字节复制时长："+(endTime-startTime)+" ms");

        clear(outPath);
        startTime = System.currentTimeMillis();
        copy04();
        endTime = System.currentTimeMillis();
        logger.info("高级流多字节复制时长："+(endTime-startTime)+" ms");

    }

    @Test
    public void clearNew(){
        clear(outPath);
    }
}
