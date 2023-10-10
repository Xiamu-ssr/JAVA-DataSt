package org.kmo.d07_NetComm.TCP01;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws Exception {
        //1.create socket and send link request to server
        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 8889);
        //2.get socket output for write message to server
        OutputStream os = socket.getOutputStream();
        //3.package low os to high os
        DataOutputStream dos = new DataOutputStream(os);
        //4.write message
        dos.writeUTF("的风格和健康fafwfa");
        System.out.println("已发送");

        //close
        dos.close();
        socket.close();
    }
}
