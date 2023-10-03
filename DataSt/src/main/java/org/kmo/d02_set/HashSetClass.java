package org.kmo.d02_set;

import java.util.*;

public class HashSetClass {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(new Integer[]{666,888,222,333,111,444,777,333,777,999,111,444}));
        Set<Integer> set = new HashSet<Integer>();
        for (Integer v:arr){
            set.add(v);
        }
        System.out.println(set);
        set = new  LinkedHashSet<Integer>();
        for (Integer v:arr){
            set.add(v);
        }
        System.out.println(set);
        set = new TreeSet<Integer>();
        for (Integer v:arr){
            set.add(v);
        }
        System.out.println(set);
    }
}
