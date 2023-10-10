package org.kmo.program.P14;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class ClientThread extends Thread{
    Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        try {
            is = socket.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        DataInputStream dis = new DataInputStream(is);
        while (true) {
            try {
                String rs = dis.readUTF();
                System.out.println(rs);
            } catch (IOException e) {
                break;
            }
        }
        //close
        try {
            System.out.println("自己下线了");
            dis.close();
            socket.close();
            System.out.println("接受信息线程关闭");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
