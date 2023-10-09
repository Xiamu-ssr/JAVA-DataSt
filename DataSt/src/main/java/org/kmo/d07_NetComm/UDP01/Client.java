package org.kmo.d07_NetComm.UDP01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {
    public static void main(String[] args) throws Exception {
        //1. create client
        DatagramSocket socket = new DatagramSocket();
        //2. create data package
        byte[] bytes = "小淇宝贝，我是莫莫，我超爱你！mua".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(),8889);
        //3.send
        socket.send(packet);
        System.out.println("客户端发送了长度为 "+bytes.length+" bytes的数据");
        System.out.println("数据为: "+new String(bytes));
        socket.close();
    }
}
