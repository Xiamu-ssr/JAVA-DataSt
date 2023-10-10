package org.kmo.program.P14;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

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
        SocketAddress rIP = socket.getRemoteSocketAddress();
        while (true) {
            try {
                String rs = dis.readUTF();
                sendMsg2All(rs);
            } catch (IOException e) {
                break;
            }
        }
        //close
        try {
            System.out.println(name+"客户端"+rIP+"离线了");
            Server.onlineSockets.remove(socket);
            dis.close();
            socket.close();
            System.out.println(name+"服务线程关闭");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMsg2All(String rs) throws IOException {
        for (Socket onlineSocket : Server.onlineSockets) {
            OutputStream os = onlineSocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(rs);
            dos.flush();
        }
    }
}
