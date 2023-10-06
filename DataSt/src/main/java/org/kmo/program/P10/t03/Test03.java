package org.kmo.program.P10.t03;

/**
 * <h2>需求</h2>
 * 小红和小明有一个共同的银行账户10万元，同时取钱，会发生什么？<br>
 * 如何处理冲突
 * <ol>
 *     <li>同步代码块</li>
 *     <li>同步方法√</li>
 *     <li>Lock锁</li>
 * </ol>
 * */

public class Test03 {
    public static void main(String[] args) {
        //1.create account object
        Account account = new Account(100000,"SN-112");
        //2.create two thread with one account
        Thread t1 = new DrawThread(account, "小明");//小明
        Thread t2 = new DrawThread(account, "小红");//小红
        t1.start();
        t2.start();

        //1.create account object
        Account account1 = new Account(100000,"SN-113");
        //2.create two thread with one account
        Thread t3 = new DrawThread(account1, "小黑");//小明
        Thread t4 = new DrawThread(account1, "小白");//小红
        t3.start();
        t4.start();
    }
}
