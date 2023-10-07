package org.kmo.program.P12.Test01;

import java.util.List;
import java.util.Random;

public class SendGift implements Runnable{
    private String name;
    private Gift gift;
    private int sendNum = 0;

    public SendGift(String name, Gift gift) {
        this.name = name;
        this.gift = gift;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (true){
            synchronized (gift){
                if (gift.size()<10){
                    break;
                }else {
                    String giftName = gift.remove(r.nextInt(gift.size()));
//                    System.out.println(name + "送出了" + giftName);
                    sendNum++;
                }
            }
        }
    }

    public int getCount(){
        return sendNum;
    }
}
