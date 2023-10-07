package org.kmo.d07_NetComm;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class Test01 {

    @Test
    public void test01() throws Exception {
        //1.get local ip
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("LoaclIP:"+localHost.getHostAddress());
        System.out.println("LocalNmae:"+localHost.getHostName());
        //2.get baidu
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println("LoaclIP:"+baidu.getHostAddress());
        System.out.println("LocalNmae:"+baidu.getHostName());
        System.out.println(baidu.isReachable(100));
    }
}
