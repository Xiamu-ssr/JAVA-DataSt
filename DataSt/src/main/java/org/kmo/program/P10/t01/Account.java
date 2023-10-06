package org.kmo.program.P10.t01;

public class Account {
    private double money;
    private String cardID;//useless

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
    public void drawMoney(double m){
        Thread ct = Thread.currentThread();
        if (money>=m){
            System.out.println(ct.getName()+"取钱"+m+"元");
            money -= m;
            System.out.println(ct.getName()+"取钱后，剩余"+money+"元");
        }else {
            System.out.println(ct.getName()+"取钱，余额不足");
        }
    }
}
