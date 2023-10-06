package org.kmo.program.P10.t04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private double money;
    private String cardID;//useless
    private final Lock lk = new ReentrantLock();

    public Account() {
    }

    public Account(double money, String cardID) {
        this.money = money;
        this.cardID = cardID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    @Override
    public String toString() {
        return "Account{" +
                "money=" + money +
                ", cardID='" + cardID + '\'' +
                '}';
    }
    //方式二：同步方法
    public synchronized void drawMoney(double m){
        Thread ct = Thread.currentThread();
        try {
            lk.lock();
            if (money>=m){
                System.out.println(ct.getName()+"取钱"+m+"元");
                money -= m;
                System.out.println(ct.getName()+"取钱后，剩余"+money+"元");
            }else {
                System.out.println(ct.getName()+"取钱，余额不足");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lk.unlock();
        }
    }
}
