package org.kmo.d07_NetComm.TCP03;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket) {
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
        String name = currentThread().getName();
        while (true) {
            try {
                System.out.println(name+"消息来自: "+socket.getRemoteSocketAddress());
                String rs = dis.readUTF();
                System.out.println(name+"消息为:"+rs);
            } catch (IOException e) {
                System.out.println(name+"客户端离线了");
                break;
            }
        }
        //close
        try {
            dis.close();
            socket.close();
            System.out.println(name+"服务线程关闭");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
