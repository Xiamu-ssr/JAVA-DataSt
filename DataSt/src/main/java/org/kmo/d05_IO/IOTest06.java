package org.kmo.d05_IO;

import org.junit.Test;
import org.kmo.utils.StudentCom;

import java.io.*;

/**
 * 序列流介绍
 * */
public class IOTest06 {
    public static class Student implements Serializable{
        private String name;
        private int age;
//        transient不参与序列化
        private transient double height;


        public Student() {
        }

        public Student(String name, int age, double height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", height=" + height +
                    '}';
        }
    }
    private final String inPath = "src/main/resources/FileIO/IOTest06/out.txt";
    private final String outPath = "src/main/resources/FileIO/IOTest06/out.txt";

    @Test
    public void test01(){
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inPath));
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outPath));
                ){
            Student s = new Student("小淇", 21, 167.9);
            oos.writeObject(s);

            System.out.println((Student)ois.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
