package org.kmo.d05_IO;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 字符集解码编码
 * */
public class CharSet01 {

    @Test
    public void test01(){
        String data = "我love你";
//        编码
        byte[] bytes = data.getBytes();
        System.out.println(Arrays.toString(bytes));

        byte[] bytes1 = null;
        try {
            bytes1 = data.getBytes("GBK");
            System.out.println(Arrays.toString(bytes1));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
//        解码
        String s = new String(bytes);
        System.out.println(s);

        String s1 = null;
        try {
            s1 = new String(bytes1, "GBK");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(s1);
    }
}
