package org.kmo.d08_Annotation.Test02;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationTest3 {

    @Test
    public void test01(){
        Class c = Demo.class;
        if (c.isAnnotationPresent(MyTest4.class)){
            MyTest4 myTest4 = (MyTest4) c.getDeclaredAnnotation(MyTest4.class);
            System.out.println(myTest4.value());
            System.out.println(myTest4.aaa());
            System.out.println(Arrays.toString(myTest4.bbb()));
        }
    }
    @Test
    public void test02() throws Exception {
        Class c = Demo.class;
        Method method = c.getDeclaredMethod("test01");
        if (method.isAnnotationPresent(MyTest4.class)){
            MyTest4 myTest4 = (MyTest4) method.getDeclaredAnnotation(MyTest4.class);
            System.out.println(myTest4.value());
            System.out.println(myTest4.aaa());
            System.out.println(Arrays.toString(myTest4.bbb()));
        }
    }
}
