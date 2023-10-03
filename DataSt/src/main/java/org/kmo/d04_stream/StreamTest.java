package org.kmo.d04_stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * <h2>初步体验Stream的方便快捷</h2>
 * */
public class StreamTest {

    @Test
    public void test01(){
        List<String> names = new ArrayList<>();
        names.add("张三");
        names.add("李四");
        names.add("张无极");
        names.add("扎名");
        names.add("石磊");
//        找出姓张并且长度为3的元素
//        一般做法
        List<String> list1 = new ArrayList<>();
        names.forEach(l->{
            if (l.startsWith("张") && l.length()==3){
                list1.add(l);
            }
        });
        System.out.println(list1);
//        stream做法
        List<String> list2 =names.stream()
                .filter(n -> n.startsWith("张"))
                .filter(n -> n.length()==3)
                .collect(Collectors.toList());
        System.out.println(list2);
    }
}
