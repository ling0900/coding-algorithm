package lh.kit.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyServer {

    private final int port;

    public NettyServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        // 创建两个EventLoopGroup，一个处理连接，一个处理IO事件
        EventLoopGroup bossGroup = new NioEventLoopGroup(2); // 负责处理客户端连接
        EventLoopGroup workerGroup = new NioEventLoopGroup(); // 负责处理读写数据
        try {
            // 1、
            ServerBootstrap b = new ServerBootstrap(); // 用于引导服务端启动
            // 2、
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // 指定NIO的模式
                    .option(ChannelOption.SO_BACKLOG, 100) // 设置TCP连接队列大小
                    .handler(new LoggingHandler(LogLevel.INFO)) // 设置日志输出
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            // 添加处理器到pipeline，处理每个连接的I/O
                            ch.pipeline().addLast(new StringDecoder()); // 解码器，将字节解码为字符串
                            ch.pipeline().addLast(new StringEncoder()); // 编码器，将字符串编码为字节
                            ch.pipeline().addLast(new SimpleServerHandler()); // 自定义的业务处理器
                        }
                    });

            //3、 绑定端口并启动服务器
            ChannelFuture f = b.bind(port).sync();

            System.out.println("Server started and listening on " + port);
            // 等待服务器通道关闭
            f.channel().closeFuture().sync();
        } finally {
            // 优雅关闭事件循环组
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    // 处理客户端连接的业务逻辑
    public static class SimpleServerHandler extends SimpleChannelInboundHandler<String> {

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
            // 接收客户端的消息并处理
            System.out.println("Received from client: " + msg);

            // 发送响应给客户端
            ctx.writeAndFlush("Message received: " + msg);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            // 捕获异常
            cause.printStackTrace();
            ctx.close(); // 关闭连接
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        new NettyServer(port).run();
    }
}
