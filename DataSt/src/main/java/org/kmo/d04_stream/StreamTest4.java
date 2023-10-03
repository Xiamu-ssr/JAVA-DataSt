package org.kmo.d04_stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <h2>Stream常用终结方法</h2>
 * */
public class StreamTest4 {
    public class Student{
        public String name;
        public int age;
        public double height;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age && Double.compare(height, student.height) == 0 && Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, height);
        }
    };

    @Test
    public void test01(){
        List<Student> students = new ArrayList<>();
        Student s1 = new Student(  "蜘蛛精",  26,172.5);
        Student s2 = new Student(  "蜘蛛精",  26, 172.5);
        Student s3 = new Student(  "紫霞",  23,  167.6);
        Student s4 = new Student(  "白晶晶",  25,  169.0);
        Student s5 = new Student(  "牛魔王",  35,  183.3);
        Student s6 = new Student(  "牛夫人",  34,  168.5);
        Collections.addAll(students, s1, s2, s3, s4, s5, s6);
        //需求1：请计算出身高超过168的学生有几人。
        System.out.println(
                students.stream()
                        .filter(s -> s.height>168)
                        .count()
        );
        //需求2：请找出身高最高的学生对象，并输出。
        System.out.println(
                students.stream()
                        .max((o1, o2)->Double.compare(o1.height, o2.height))
        );
        //需求3：请找出身高最矮的学生对象，并输出。
        Student tmp = students.stream()
                        .min((o1, o2)->Double.compare(o1.height, o2.height))
                        .get();
        System.out.println(tmp);
        //需求4：请找出身高超过170的学生对象，并放到一个新集合中去返回。
        List<Student> list = students.stream()
                .filter(s -> s.height > 170)
                .collect(Collectors.toList());
        System.out.println(list);
        Set<Student> set = students.stream()
                .filter(s -> s.height > 170)
                .collect(Collectors.toSet());
        System.out.println(set);
        //需求5：请找出身高超过170的学生对象，并把学生对象的名字和身高，存入到一个Map集合返回。
        Map<String, Double> map1 = students.stream()
                .filter(s -> s.height > 170)
                .distinct().collect(Collectors.toMap(Student::getName, Student::getHeight));
//                .collect(Collectors.toMap(Student::getName, Student::getHeight, Math::max));
        System.out.println(map1);
//        输出到array
        Object[] array = students.stream().toArray();
        for (Object o : array) {
            System.out.println(o);
        }
        Student[] array2 = students.stream().toArray(Student[]::new);
        for (Student o : array2) {
            System.out.println(o.name);
        }
    }
}
