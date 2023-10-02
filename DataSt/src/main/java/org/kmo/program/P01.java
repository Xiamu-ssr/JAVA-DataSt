package org.kmo.program;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * <h2>斗地主</h2>
 * 业务需求分析：
 * <ul>
 *     <li>共有54张牌</li>
 *     <li>13种点数：3,4,5,6,7,8,9,10,J,Q,K,A,2</li>
 *     <li>4种花色：黑桃，红桃，梅花，方块</li>
 *     <li>大小王共2张</li>
 *     <li>发出51张牌，3张作为底牌</li>
 * </ul>
 * */

public class P01 {
    private Logger logger = LoggerFactory.getLogger("斗地主");
    private final String testflag = "";//or ""

//牌类
    private class Card implements Comparable<Card>{
        private String number;
        private String color;
        private int size;

        public Card(String number, String color, int size) {
            this.number = number;
            this.color = color;
            this.size = size;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return color+number;
        }

        @Override
        public int compareTo(Card o) {
            return Integer.compare(this.size, o.size);
        }
    }
//玩家
    private class Player{
    public String name;
    public List<Card> cards;
    public Player(String name){
        this.name = name;
        this.cards = new ArrayList<>();
    }
    public void getCard(Card c){
        cards.add(c);
    }
    public void getCard(List<Card> c){
        cards.addAll(c);
    }
    public void sortCards(){
        Collections.sort(cards);
    }
}
//房间
    private class Room{
        private String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        private String[] color = {"♦","♣","♥","♠"};
        private ArrayList<Card> allCards = new ArrayList<>();
        private Player[] players;
        /**
         * 初始化房间时，存入54张牌
         * */
        public Room(){
            for (int i = 0; i < numbers.length; i++) {
                for (int i1 = 0; i1 < color.length; i1++) {
                    allCards.add(new Card(numbers[i], color[i1],i));
                }
            }
            allCards.add(new Card("小王","🃏",13));
            allCards.add(new Card("大王","🃏",14));
            players = new Player[]{new Player("令狐冲"), new Player("卢欧洛"), new Player("鸠摩")};
            logger.info("房间初始化成功");
        }
        /**
         * 游戏开始
         * */
        public void start(){
//            洗牌
            if (testflag.equals("test")){
                System.out.print("洗牌前：");
                System.out.println(allCards);
            }
            Collections.shuffle(allCards);
            logger.info("洗牌成功");
            if (testflag.equals("test")){
                System.out.print("洗牌后：");
                System.out.println(allCards);
            }
//            发牌
            for (int i = 0; i < allCards.size()-3; i++) {
                players[i%3].getCard(allCards.get(i));
            }
            for (int i=0; i<3; ++i){
                players[i].sortCards();
            }
            logger.info("发牌成功");
            if (testflag.equals("test")){
                for (int i=0; i<3; ++i){
                    System.out.printf("%-8s:",players[i].name);
                    System.out.println(players[i].cards);
                }
            }
//          抢地主
            List<Card> lastCards = allCards.subList(allCards.size()-3, allCards.size());
            int random = (int)(Math.random()*3);
            players[random].getCard(lastCards);
            players[random].sortCards();
            logger.info("身份分配成功");
            if (testflag.equals("test")){
                System.out.print("底牌为：");
                System.out.println(lastCards);
                System.out.printf("%-8s抢到地主\n",players[random].name);
            }
//            看牌
            logger.info("玩家看牌");
            for (int i=0; i<3; ++i){
                System.out.printf("%-8s:",players[i].name);
                System.out.println(players[i].cards);
            }
        }
    }

    @Test
    public void test01(){
        Room r1 = new Room();
        r1.start();

    }

}


