package org.kmo.program;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <h2>需求：</h2>
 * 某个班级80人，班长提供四个景点依次是ABCD，每个学生只能选一个，统计哪个景点去的人最多
 * */
public class P02 {


    @Test
    public void test01(){
//        1.拿到学生选择数据
        List<String> list = new ArrayList<>();
        String[] select = {"A", "B", "C", "D"};
        Random r = new Random();
        for (int i=0; i<80; ++i){
            int s = r.nextInt(4);
            list.add(select[s]);
        }
        System.out.println(list);
    }
}
