package org.kmo.program;

import org.junit.Test;

import java.util.*;

/**
 * <h2>需求</h2>
 * 集合嵌套实践，记录省份及其对应城市信息<br/>
 * 江苏省 = 南京市，扬州市，苏州市，无锡市，常州市<br/>
 * 湖北省 = 武汉市，孝感市，十堰市，宜昌市，鄂州市<br/>
 * 河北省 = 石家庄市，唐山市，邢台市，保定市，张家口市<br/>
 * */

public class P03 {

    @Test
    public void test01(){
        Map<String, List<String>> record = new HashMap<>();
        record.put("江苏省", new ArrayList<>(Arrays.asList("南京市","扬州市","苏州市","无锡市","常州市")));
        record.put("湖北省", new ArrayList<>(Arrays.asList("武汉市","孝感市","十堰市","宜昌市","鄂州市")));
        record.put("河北省", new ArrayList<>(Arrays.asList("石家庄市","唐山市","邢台市","保定市","张家口市")));
        System.out.println(record);

        List<String> list =  record.get("湖北省");
        for (String s : list) {
            System.out.println(s);
        }

    }
}
