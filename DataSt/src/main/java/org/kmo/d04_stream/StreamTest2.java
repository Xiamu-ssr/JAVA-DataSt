package org.kmo.d04_stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <h2>不同对象的Stream调用</h2>
 * */
public class StreamTest2 {

    @Test
    public void test01(){
        //1、如何获取List集合的Stream流?
        List<String> names = new ArrayList<>();
        Collections.addAll(names,"张三丰","张无忌","周芷若","赵敏","张强");
        Stream<String> stream1 = names.stream();


        //2、如何获取Set集合的Stream流？
        Set<String> set = new HashSet<>();
        Collections.addAll(set,"刘德华","张曼玉","蜘蛛精","马德","德玛西亚");
        Stream<String> stream2 = set.stream();
        stream2.filter(s -> s.contains("德")).forEach(s -> System.out.println(s));

        //3、如何获取Map集合的Stream流？
        Map<String, Double> map = new HashMap<>();
        map.put("古力娜扎", 172.3);
        map.put("迪丽热巴", 168.3);
        map.put("马尔扎哈", 166.3);
        map.put("卡尔扎巴", 168.3);
        Stream<Map.Entry<String, Double>> stream = map.entrySet().stream();
        map.entrySet().stream().filter(s -> s.getKey().contains("尔")).forEach(s -> System.out.println(s));

        //4、如何获取数组的Stream流？
        String[] names2 = {"张翠山","东方不败","唐大山","独孤求败"};
        Arrays.stream(names2).filter(n -> n.length()==3).forEach(n -> System.out.println(n));
        Stream.of(names2).filter(n -> n.length()==3).forEach(n -> System.out.println(n));
    }
}
