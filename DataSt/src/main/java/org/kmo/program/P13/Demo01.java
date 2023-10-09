package org.kmo.program.P13;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;


/**
 * <H2>需求</H2>
 * <p>对于任意对象，将对象的字段名和对应的值保存到文件中去</p>
 * */

public class Demo01 {
    private String dirPath = "src/main/resources/P13/";

    @Test
    public void test01() {
        Student s1 = new Student("淇",22,'女',167.56,"swim");
        Teacher t1 = new Teacher("柳",5433.2);

        work(s1, dirPath+"s.txt");
        work(t1, dirPath+"t.txt");
    }

    public void work(Object object, String filePath) {
        //1.create fileIO
        try (
//                FileWriter fileWriter = new FileWriter(filePath);
                PrintWriter printWriter = new PrintWriter(filePath);
        ) {
            //2.get Object fields info
            Class c = object.getClass();
            Field[] declaredFields = c.getDeclaredFields();
            printWriter.println("--------"+c.getSimpleName()+"--------");
            for (Field f : declaredFields) {
                f.setAccessible(true);
                printWriter.println(f.getName()+" --> "+f.get(object));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
