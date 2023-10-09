package org.kmo.d07_NetComm.UDP01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws Exception {
        //1. create server socket
        DatagramSocket socket = new DatagramSocket(8889);
        //2. create packet
        byte[] bytes = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        //3.receive
        socket.receive(packet);

        System.out.println("服务端收到了长度为 "+packet.getLength()+" bytes的数据");
        System.out.println("数据为: "+new String(bytes,0, packet.getLength()));
        System.out.println("消息来自:\nIP->"+packet.getAddress().getHostAddress());
        System.out.println("Name->"+packet.getAddress().getHostName());
        System.out.println("Port->"+packet.getPort());

        socket.close();
    }
}
