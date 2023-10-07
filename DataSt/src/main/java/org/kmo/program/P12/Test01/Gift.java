package org.kmo.program.P12.Test01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gift {
    private List<String> list;
    private final String[] names = {"口红","牛奶","衣服","显卡","游戏机","冰箱"};

    public Gift(int num) {
        this.list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < num; i++) {
            list.add(names[r.nextInt(names.length)] + i);
        }
    }
    public void print(){
        System.out.println(list);
    }
    public int size(){
        return list.size();
    }
    public String remove(int index){
        return list.remove(index);
    }
}
