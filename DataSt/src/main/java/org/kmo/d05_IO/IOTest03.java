package org.kmo.d05_IO;

import org.junit.Test;

import java.io.*;

/**
 * 缓冲流
 * */

public class IOTest03 {
    private final String inPath = "src/main/resources/FileIO/1.txt";
    private final String outPath = "src/main/resources/FileIO/2.txt";

    public void clear(){
        File file = new File(outPath);
//        System.out.println(file.getAbsolutePath());
        boolean delete = file.delete();
        System.out.println(delete);
    }

    /**
     * 字节缓冲流
     * */
    @Test
    public void test01() {
        clear();
        try (
                InputStream is = new FileInputStream(inPath);
                InputStream bis = new BufferedInputStream(is);

                OutputStream os = new FileOutputStream(outPath);
                OutputStream bos = new BufferedOutputStream(os);
        ) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 字符缓冲流
     * */
    @Test
    public void test02(){
        clear();
        try (
                FileReader fr = new FileReader(inPath);
                BufferedReader bfr = new BufferedReader(fr);

                FileWriter fw = new FileWriter(outPath);
                BufferedWriter bfw = new BufferedWriter(fw);
                ) {
//            char[] ch = new char[1024];
//            int len;
//            while ((len = bfr.read(ch)) != -1){
//                bfw.write(ch,0,len);
//            }
            String line;
            while ((line=bfr.readLine())!=null){
                bfw.write(line);
                bfw.newLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
