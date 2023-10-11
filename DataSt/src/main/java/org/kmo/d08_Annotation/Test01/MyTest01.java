package org.kmo.d08_Annotation.Test01;

import org.junit.Test;

@MyAnnotation(aaa="牛魔王", ccc={"Python","Java"})
public class MyTest01 {
    @MyAnnotation(aaa="铁山",bbb=false,ccc={"C++","C"})
    public void test1(){

    }

    @MyAnnotation2("孙悟空")
    public void test2(){

    }
    
    public static void main(String[] args) {

    }
}
