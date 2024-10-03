package lh.kit.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        Selector selector;
        ServerSocketChannel serverSocketChannel;

        try {

            // 打开选择器
            selector = Selector.open();

            // 打开服务端Socket通道
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(PORT));

            // 配置为非阻塞模式
            serverSocketChannel.configureBlocking(false);

            // 注册通道到选择器，关心的是接收事件（OP_ACCEPT）
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("NIO Server started on port: " + PORT);

            // 主循环，等待事件
            while (true) {
                // 等待事件发生（阻塞操作，直到有事件触发）
                selector.select();

                // 获取事件的集合
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();

                    // 删除当前处理的 key，避免重复处理
                    keyIterator.remove();

                    // 处理事件
                    if (key.isAcceptable()) {
                        // 处理链接时间
                        handleAccept(key, selector);
                    } else if (key.isReadable()) {
                        // 处理读时间
                        handleRead(key);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 处理客户端连接
    private static void handleAccept(SelectionKey key, Selector selector) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel clientChannel = serverSocketChannel.accept();
        clientChannel.configureBlocking(false);

        System.out.println("Client connected: " + clientChannel.getRemoteAddress());

        // 注册客户端通道到选择器，关注读事件
        clientChannel.register(selector, SelectionKey.OP_READ);
    }

    // 处理客户端发来的消息
    private static void handleRead(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 读取数据到 buffer
        int bytesRead = clientChannel.read(buffer);

        if (bytesRead == -1) {
            // 客户端关闭连接
            clientChannel.close();
            System.out.println("Client disconnected");
        } else {
            // 切换 buffer 到读模式
            buffer.flip();
            byte[] data = new byte[buffer.limit()];
            buffer.get(data);
            System.out.println("Received from client: " + new String(data));

            // 回送数据给客户端
            buffer.clear();
            buffer.put("Message received".getBytes());
            buffer.flip();
            clientChannel.write(buffer);
        }
    }
}

