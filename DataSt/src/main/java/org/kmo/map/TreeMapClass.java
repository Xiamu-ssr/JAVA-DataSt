package org.kmo.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapClass {


    @Test
    public void test01(){
        Map<String, Integer> map = new TreeMap<>();//一行经典代码
        map.put("阿胶",345);
        map.put("弹珠",3);
        map.put("手机",2900);
        map.put("肉",34);
        map.put("手表",100);
        map.put("足利键",200);
        System.out.println(map);
    }
}
