package org.kmo.program;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h2>需求</h2>
 * 使用缓冲流，读取古诗并复原顺序
 * */
public class P08 {
    private final String inPath = "src/main/resources/FileIO/P08/1.txt";
    private final String outPath = "src/main/resources/FileIO/P08/2.txt";

    public void clear(String path){
        File file = new File(path);
        file.delete();
    }

    private class oneLine implements Comparable<oneLine>{
        private int size;
        private String line;

        public oneLine(int size, String line) {
            this.size = size;
            this.line = line;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getLine() {
            return line;
        }

        public void setLine(String line) {
            this.line = line;
        }

        @Override
        public String toString() {
            return "oneLine{" +
                    "size=" + size +
                    ", line='" + line + '\'' +
                    '}';
        }

        @Override
        public int compareTo(oneLine o) {
            return Integer.compare(this.size, o.size);
        }
    }

    @Test
    public void test01(){
        clear(outPath);
        List<oneLine> poem = new ArrayList<>();
        try (
                FileReader fr = new FileReader(inPath);
                BufferedReader br = new BufferedReader(fr);

                FileWriter fw = new FileWriter(outPath);
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            String line;
            while ((line = br.readLine())!=null){
                int index = line.indexOf('.');
                int size = Integer.parseInt(line.substring(0, index));
                String l = line.substring(index+1);
                poem.add(new oneLine(size, l));
            }
            Collections.sort(poem);
            for (oneLine oneline : poem) {
                bw.write(oneline.getLine());
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
