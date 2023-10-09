package org.kmo.d07_NetComm.UDP02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        //1. create client
        DatagramSocket socket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请说：");
            String s = sc.nextLine();
            if ("exit".equals(s)){
                System.out.println("欢迎下次使用~");
                break;
            }
            //2. create data package
            byte[] bytes = s.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(),8889);
            //3.send
            socket.send(packet);
            System.out.println("客户端发送了长度为 "+bytes.length+" bytes的数据");
            System.out.println("数据为: "+new String(bytes));
            System.out.println("----------------------");
        }
        socket.close();
    }
}
