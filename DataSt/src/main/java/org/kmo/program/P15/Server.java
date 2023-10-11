package org.kmo.program.P15;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *<h2>需求</h2>
 * <p>BS架构，浏览器访问服务器端口，服务器返回信息，使用线程池优化</p>
 * */

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8889);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(12*2, 12*2, 0, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(8),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        while (true) {
            //2.wait client link request
            Socket socket = serverSocket.accept();
            System.out.println(socket.getRemoteSocketAddress()+"上线了");
            threadPool.execute(new ServerThread(socket));
        }
    }
}
