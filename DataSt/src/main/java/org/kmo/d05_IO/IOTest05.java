package org.kmo.d05_IO;

import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * 数据流介绍
 * */
public class IOTest05 {
    private final String inPath = "src/main/resources/FileIO/IOTest05/out.txt";
    private final String outPath = "src/main/resources/FileIO/IOTest05/out.txt";

    @Test
    public void test01(){
        try (
                DataInputStream dis = new DataInputStream(new FileInputStream(inPath));
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(outPath));
                ){
            dos.writeByte(97);
            dos.writeInt(101);
            dos.writeBoolean(false);
            dos.writeDouble(10.99);
            dos.writeUTF("我爱你");

            System.out.println(dis.readByte());
            System.out.println(dis.readInt());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readDouble());
            System.out.println(dis.readUTF());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
