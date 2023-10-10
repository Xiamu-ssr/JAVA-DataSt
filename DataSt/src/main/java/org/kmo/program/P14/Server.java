package org.kmo.program.P14;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *<h2>需求</h2>
 * <p>一个服务器+四个客户端，实现群聊功能，某客户端发送的信息需同步到其余所有客户端</p>
 * */

public class Server {
    public static List<Socket> onlineSockets = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8889);

        while (true) {
            //2.wait client link request
            Socket socket = serverSocket.accept();
            onlineSockets.add(socket);
            System.out.println(socket.getRemoteSocketAddress()+"上线了");
            new ServerThread(socket).start();
        }
    }
}
