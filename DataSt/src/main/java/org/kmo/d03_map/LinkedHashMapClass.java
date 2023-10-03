package org.kmo.d03_map;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapClass {


    @Test
    public void test01(){
        Map<String, Integer> map = new LinkedHashMap<>();//一行经典代码
        map.put("阿胶",345);
        map.put("弹珠",3);
        map.put("手机",2900);
        map.put("肉",34);
        map.put("手表",100);
        map.put("足利键",200);
        System.out.println(map);
    }
}
