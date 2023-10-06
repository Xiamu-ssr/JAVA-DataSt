package org.kmo.program.P11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Desk {
    private List<String> list = new ArrayList<>();
    private Lock lk = new ReentrantLock();
    public void put(){
        if (list.isEmpty()){
            String name = Thread.currentThread().getName();
            try {
                System.out.println(name+"正在做一个肉包子");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                lk.lock();
                list.add(name+"做的肉包子");
                System.out.println(name+"放了一个肉包子");
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lk.unlock();
            }
        }else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void get(){
        if (!list.isEmpty()){
            String name = Thread.currentThread().getName();
            try {
                lk.lock();
                list.remove(0);
                System.out.println(name+"拿走了一个肉包子");
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lk.unlock();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name+"吃完了一个肉包子");
        }else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
