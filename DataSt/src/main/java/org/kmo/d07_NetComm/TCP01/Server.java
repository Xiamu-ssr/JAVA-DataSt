package org.kmo.d07_NetComm.TCP01;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

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
        //5.receive message
        System.out.println("消息来自: "+socket.getRemoteSocketAddress());
        String rs = dis.readUTF();
        System.out.println("消息为:"+rs);
        //close
        dis.close();
        socket.close();
    }
}
