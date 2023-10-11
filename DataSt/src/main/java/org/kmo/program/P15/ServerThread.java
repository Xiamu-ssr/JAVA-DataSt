package org.kmo.program.P15;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;

public class ServerThread implements Runnable {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            String name =  Thread.currentThread().getName();
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=UTF-8");
            ps.println();
            ps.println("<h2>回应</h2>");
            ps.println("<p>"+name+"已响应</p>");
            ps.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
