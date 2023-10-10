package org.kmo.d07_NetComm.TCP02;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        //1.create serversocket
        ServerSocket serverSocket = new ServerSocket(8889);
        //2.wait client link request
        Socket socket = serverSocket.accept();
        //3.get input is for receive message
        InputStream is = socket.getInputStream();
        //4.package low is to high is
        DataInputStream dis = new DataInputStream(is);
        while (true) {
            try {
                //5.receive message
                System.out.println("消息来自: "+socket.getRemoteSocketAddress());
                String rs = dis.readUTF();
                System.out.println("消息为:"+rs);
            } catch (IOException e) {
                System.out.println("客户端离线了");
                break;
            }
        }
        //close
        dis.close();
        socket.close();
    }
}
