package org.kmo.list;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class ArrayListClass {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("");
        ArrayList<String> arr = new ArrayList<String>();
//        add
        logger.info("add");
        arr.add("jack");
        arr.add("naco");
        arr.add("naco");
        arr.add("need");
        System.out.println(arr);
//        addAll
        logger.info("addAll");
        ArrayList<String> arr2 = new ArrayList<String>();
        arr2.addAll(0,arr);
        System.out.println(arr2);
//        clear
        logger.info("clear");
        arr2.clear();
        System.out.println(arr2);
//        contains
        logger.info("contains");
        System.out.println(arr.contains("need"));
//        get
        logger.info("get");
        System.out.println(arr.get(1));
//        indexOf
        logger.info("indexOf");
        System.out.println(arr.indexOf("need"));
//        removeAll
        logger.info("removeAll");
        arr2.add(arr.get(1));
        arr.removeAll(arr2);
        System.out.println(arr);
//        size
        logger.info("size");
        System.out.println(arr.size());
//        更多api请看https://www.runoob.com/manual/jdk11api/java.base/java/util/ArrayList.html
        for (String e:arr){
            System.out.printf("%s ",e);
        }
    }
}
