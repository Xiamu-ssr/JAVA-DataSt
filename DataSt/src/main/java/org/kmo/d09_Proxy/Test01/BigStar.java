package org.kmo.d09_Proxy.Test01;

public class BigStar implements Star{
    private String name;

    public BigStar(String name) {
        this.name = name;
    }
    public String sing(String n){
        System.out.println(name+"开始唱一首名为《"+n+"》的歌");
        return "谢谢";
    }
    public void dance(){
        System.out.println(name+"开始跳舞");
    }
}
