package org.kmo.program.P12.Test01;

/**
 * <h2>训练目标：</h2>
 * <p>掌握java中多线程基本使用</p>
 * <h2>需求描述:</h2>
 * <p>有100份礼品,小红,小明两人同时发送,当剩下的礼品小于10份的时候则不再送出,利用多线程模拟该过程并将线程的名称打印出来。并最后在控制台分别打印小红，小明各自送出多少分礼物。</p>
 * */
public class Demo01 {
    public static void main(String[] args) throws InterruptedException {
        Gift gift = new Gift(100);

        SendGift target1 = new SendGift("小明", gift);
        SendGift target2 = new SendGift("小红", gift);

        Thread t1 = new Thread(target1);
        Thread t2 = new Thread(target2);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("小明"+target1.getCount());
        System.out.println("小红"+target2.getCount());


    }
}
