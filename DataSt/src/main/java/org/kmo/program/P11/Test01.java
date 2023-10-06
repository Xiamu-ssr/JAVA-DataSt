package org.kmo.program.P11;
/**
 * <h2>需求</h2>
 * <p>模拟3厨师和2顾客生产消费包子</p>
 * <p>通过线程通信,告知生产者或消费者是否应该继续，来降低资源消耗</p>
 * <p>例子并不好，这里锁的是包子数量而不是桌子</p>
 * <p>如果锁桌子，可以使用类的this.wait()和this.notifyAll()来互动线程状态</p>
 * <p>不过如果锁包子数量的话，更新和判断包子数量也可以来更新线程状态，同时锁的范围也小</p>
 * */

public class Test01 {

    public static void main(String[] args) {
        Desk desk = new Desk();

        //1.create 3 producer
        new Thread(()->{
            while (true){
                desk.put();
            }
        },"厨师1").start();
        new Thread(()->{
            while (true){
                desk.put();
            }
        },"厨师2").start();
        new Thread(()->{
            while (true){
                desk.put();
            }
        },"厨师3").start();
        //2.create 2 consumer
        new Thread(()->{
            while (true){
                desk.get();
            }
        },"顾客1").start();
        new Thread(()->{
            while (true){
                desk.get();
            }
        },"顾客2").start();
    }
}
