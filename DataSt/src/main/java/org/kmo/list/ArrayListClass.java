package org.kmo.list;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    /**
     * 理解集合的并发修改异常问题，并解决
     * <ol>
     *     <li>test02,test03是错误示例</li>
     *     <li>test04,test05是正确示例</li>
     *     <ul>
     *         <li>使用自带的iter的remove或者手写for逻辑</li>
     *     </ul>
     * </ol>
     * */
    @Test
    public void test02(){
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("张云飞");
        list.add("李柳");
        list.add("李斯");
//        删除全部带李的元素
        for (String s : list) {
            if (s.contains("李")){
                list.remove(s);
            }
        }
        System.out.println(list);
    }
    @Test
    public void test03(){
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("张云飞");
        list.add("李柳");
        list.add("李斯");
//        删除全部带李的元素
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String name = it.next();
            if (name.contains("李")){
                list.remove(name);
            }
        }
        System.out.println(list);
    }
    @Test
    public void test04(){
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("张云飞");
        list.add("李柳");
        list.add("李斯");
//        删除全部带李的元素
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if (name.contains("李")){
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
    }
    @Test
    public void test05(){
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("张云飞");
        list.add("李柳");
        list.add("李斯");
//        删除全部带李的元素
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String name = it.next();
            if (name.contains("李")){
                it.remove();
            }
        }
        System.out.println(list);
    }

}
