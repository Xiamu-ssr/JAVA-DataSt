package org.kmo.d01_list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListClass {
    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();
        list.add(0,"I");
        System.out.println( list.get(0));
    }
}
