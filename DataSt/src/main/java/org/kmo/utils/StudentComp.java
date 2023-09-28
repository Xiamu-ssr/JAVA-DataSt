package org.kmo.utils;

import java.util.Objects;
/**
 * <h2>带Comparable的Student类</h2>
 * */

public class StudentComp implements Comparable<StudentComp> {
    private String name;
    private int age;
    private double height;

    /**      左边大于右边，this>o，返回正整数
     *       左边小于右边，this &lt; o，返回负整数
     *       左边等于右边，this=o，返回0
     *       <b>需求</b>
     *       按照age升序排序,按height升序，按name升序
     */
    @Override
    public int compareTo(StudentComp o) {
        if (this.age!=o.age){
            return Integer.compare(this.age, o.age);
        }else if (this.height!=o.height){
            return Double.compare(this.height, o.height);
        }else{
            return this.name.compareTo(o.name);
        }
    }

    public StudentComp(String name, int age, double height) {
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
        StudentComp student = (StudentComp) o;
        return age == student.age && Double.compare(height, student.height) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, height);
    }
}
