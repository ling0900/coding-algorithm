package lh.kit.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 这是一个bio的服务端。
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            Socket accept = serverSocket.accept();// 1、会阻塞到有客户端连接
            System.out.println("accept");
            new Thread(() -> {
                try {
                    byte[] bytes = new byte[1024];
                    accept.getInputStream().read(bytes);// 2、会阻塞到有数据写入
                    System.out.println(new String(bytes));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();

        }
    }
}
