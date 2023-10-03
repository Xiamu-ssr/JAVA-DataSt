package org.kmo.map;

import org.junit.Test;

import java.util.*;
import java.util.function.BiConsumer;

public class HashMapClass {

    @Test
    public void test01(){
        Map<String, Integer> map = new HashMap<>();//一行经典代码
        map.put("阿胶",345);
        map.put("弹珠",3);
        map.put("手机",2900);
        map.put("肉",34);
        map.put("手表",100);
        map.put("足利键",200);
        System.out.println(map);
    }
    /**
     *把key和value可以分别导出到Set和Collection
     * */
    @Test
    public void test02(){
        Map<String, Integer> map = new HashMap<>();//一行经典代码
        map.put("阿胶",345);
        map.put("弹珠",3);
        map.put("手机",2900);
        map.put("肉",34);
        map.put("手表",100);
        map.put("足利键",200);
        System.out.println(map);

        Set<String> set = map.keySet();
        System.out.println(set);

        Collection<Integer> col = map.values();
        System.out.println(col);
    }
    /**
     * Map遍历
     * <ol>
     *     <li>键找值</li>
     *     <li>键值对</li>
     *     <li>lambda</li>
     * </ol>
     * */
    @Test
    public void test03(){
        Map<String, Double> map = new HashMap<>();
        map.put("蜘蛛精", 162.7);
        map.put("蜘蛛精", 167.9);
        map.put("紫霞", 165.1);
        map.put("至尊宝", 177.5);
        map.put("牛魔王", 175.2);
        System.out.println(map);

//        1.键找值
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s + ": "+map.get(s));
        }
//        2.键值对
        Set<Map.Entry<String, Double>> set2 = map.entrySet();
        for (Map.Entry<String, Double> s : set2) {
            System.out.println(s.getKey() + ": " + s.getValue());
        }
//        3.lambda
        map.forEach((k, v)->{
            System.out.println(k + ": " + v);
        });
//        3.2
        map.forEach(new BiConsumer<String, Double>() {
            @Override
            public void accept(String s, Double aDouble) {
                System.out.println(s + ": " + aDouble);
            }
        });
    }
}
