package org.kmo.program.P16;

import org.kmo.d08_Annotation.Test02.MyTest4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <h2>需求</h2>
 * <p>定义若干个方法,只要加了MyTest注解,就会触发该方法执行。</p>
 * <b>分析</b>
 * <ol>
 *     <li>定义一个自定义注解MyTest，只能注解方法，存活范围是一直都在。</li>
 *     <li>定义若干个方法,部分方法加上@MyTest注解修饰,部分方法不加。</li>
 *     <li>模拟一个junit程序，可以触发加了@MyTest注解的方法执行。</li>
 * </ol>
 * */

public class Demo {
    @MyTest()
    public void test01(){
        System.out.println("===Test01====");
    }

    public void test02(){
        System.out.println("===Test02====");
    }

    @MyTest
    public void test03(){
        System.out.println("===Test03====");
    }
    public void test04(){
        System.out.println("===Test04====");
    }

    public static void main(String[] args) throws Exception {
        Demo demo = new Demo();
        Class c = Demo.class;
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyTest.class)){
                 method.invoke(demo);
            }
        }
    }
}
