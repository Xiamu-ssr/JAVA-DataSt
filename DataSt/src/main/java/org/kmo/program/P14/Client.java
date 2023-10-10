package org.kmo.program.P14;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        //1.create socket and send link request to server
        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 8889);
        new ClientThread(socket).start();
        //2.get socket output for write message to server
        OutputStream os = socket.getOutputStream();
        //3.package low os to high os
        DataOutputStream dos = new DataOutputStream(os);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请说");
            String s = sc.nextLine();
            if (s.equals("exit")){
                break;
            }
            //4.write message
            dos.writeUTF(s);
            dos.flush();//立刻发送
            System.out.println("已发送~");
        }

        //close
        dos.close();
        socket.close();
    }
}
