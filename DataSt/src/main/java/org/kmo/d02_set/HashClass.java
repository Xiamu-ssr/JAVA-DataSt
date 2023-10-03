package org.kmo.d02_set;

import java.util.ArrayList;
import java.util.List;

public class HashClass {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(100);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(100);
        System.out.println(list1.hashCode());
        System.out.println(list2.hashCode());
    }
}
