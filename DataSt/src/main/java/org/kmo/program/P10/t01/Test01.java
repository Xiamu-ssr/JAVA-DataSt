package org.kmo.program.P10.t01;

/**
 * <h2>需求</h2>
 * 小红和小明有一个共同的银行账户10万元，同时取钱，会发生什么？<br>
 * 理解线程冲突
 * */

public class Test01 {
    public static void main(String[] args) {
        //1.create account object
        Account account = new Account(100000,"SN09077997112");
        //2.create two thread with one account
        Thread t1 = new DrawThread(account, "小明");//小明
        Thread t2 = new DrawThread(account, "小红");//小红
        t1.start();
        t2.start();
    }
}
