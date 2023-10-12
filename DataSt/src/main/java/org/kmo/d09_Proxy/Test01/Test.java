package org.kmo.d09_Proxy.Test01;

public class Test {
    public static void main(String[] args) {
        BigStar bigStar = new BigStar("杨超越");
        Star proxy = ProxyUtil.createProxy(bigStar);
        String s = proxy.sing("好日子");
        System.out.println(s);
        proxy.dance();
    }
}
