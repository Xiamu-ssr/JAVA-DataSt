package org.kmo.d07_NetComm.TCP03;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        //1.create serversocket
        ServerSocket serverSocket = new ServerSocket(8889);

        while (true) {
            //2.wait client link request
            Socket socket = serverSocket.accept();
            new ServerThread(socket).start();
        }
    }
}
