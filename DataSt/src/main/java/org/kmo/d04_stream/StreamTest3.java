package org.kmo.d04_stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <h2>Stream常用中间方法</h2>
 * */
public class StreamTest3 {
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
    };

    @Test
    public void test01(){
        List<Double> scores = new ArrayList<>();
        Collections.addAll(scores, 88.5, 108.8, 60.0, 99.0, 9.5, 99.6, 25.0);
        //需求1:找出成绩人于等于60分的数据,并升序后,可输出。
        List<Double> list1 = scores.stream()
                .filter(s -> s > 60)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(list1);


        List<Student> students = new ArrayList<>();
        Student s1 = new Student("蜘蛛精", 26, 172.5);
        Student s2 = new Student("蜘蛛精", 26, 172.5);
        Student s3 = new Student("紫霞", 23, 167.6);
        Student s4 = new Student("白晶晶", 25, 169.0);
        Student s5 = new Student("牛魔王", 35, 183.3);
        Student s6 = new Student("牛夫人", 34, 168.5);
        Collections.addAll(students, s1, s2, s3, s4, s5, s6);
        // 需求2： 找出年龄大于等于23，且年龄小于等于30岁的学生，并按照年龄降序输出
        List<Student> list2 = students.stream()
                .filter(s -> s.age >= 23 && s.age <= 30)
//                .sorted(new Comparator<Student>() {
//                    @Override
//                    public int compare(Student o1, Student o2) {
//                        return Integer.compare(o1.age, o2.age);
//                    }
//                })
                .sorted((o1, o2) -> Integer.compare(o1.age, o2.age))
                .collect(Collectors.toList());
        System.out.println(list2);
        // 需求3：取出身高最高的前3名学生，并输出。
        List<Student> list3 = students.stream()
                .sorted((o1, o2) -> Double.compare(o2.height, o1.height))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(list3);
        // 需求4：取出身高倒数的2名学生，并输出。
        List<Student> list4 = students.stream()
                .sorted((o1, o2) -> Double.compare(o2.height, o1.height))
                .skip(students.size()-2)
                .collect(Collectors.toList());
        System.out.println(list4);
        //需求5：找出身高超过168的学生叫什么名字，要求去除重复的名字，冉输出。
        List<String> list5 = students.stream()
                .filter(s -> s.height > 168)
                .map(Student::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list5);
//        List<String> list6 = students.stream()
//                .filter(s -> s.height > 168)
//        需要重写HashCode和equals
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(list6);

//        需求6：合并流
        Stream<String> stream1 = Stream.of("张三", "李四");
        Stream<String> stream2 = Stream.of("张三2", "李四2", "王五");
        Stream<String> streamAll = Stream.concat(stream1, stream2);
        streamAll.forEach(s -> System.out.println(s));
    }
}
