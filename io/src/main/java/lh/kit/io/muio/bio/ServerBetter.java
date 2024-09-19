package lh.kit.io.muio.bio;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO服务端源码
 * 伪异步I/O
 *
 * @author lh
 * @version 1.0
 */
public final class ServerBetter {

	// 默认的端口号
	private static final int DEFAULT_PORT = 33339;

	// 单例的ServerSocket
	private static ServerSocket server;

	//线程池 懒汉式的单例 设置一定的数量（corePoolSize）
	private static final ExecutorService executorService = Executors.newFixedThreadPool(60);

	/**
	 * Start.
	 * 根据传入参数设置监听端口，如果没有参数调用以下方法并使用默认值
	 * @throws IOException the io exception
	 */
	public static void start() throws IOException{
		//使用默认值
		start(DEFAULT_PORT);
	}

	/**
	 * Start.
	 * 这个方法不会被大量并发访问，不太需要考虑效率，直接进行方法同步就行了
	 * @param port the port
	 * @throws IOException the io exception
	 */
	public synchronized static void start(int port) throws IOException{

		if(server != null) return;

		try {
			/*
			通过构造函数创建ServerSocket
			如果端口合法且空闲，服务端就监听成功
			*/
			server = new ServerSocket(port);
			System.out.println("启动：" + port);
			Socket socket;

			// 阻塞在accept操作上，等待客户端的计入
			long l = System.currentTimeMillis();

			// 类似于长链接
			while (true) {
				socket = server.accept();
				// 当有新的客户端接入时，会执行下面的代码
				// 然后创建一个新的线程处理这条Socket链路
				executorService.execute(new ServerHandler(socket));
			}

		} catch (Exception e) {

		} finally {
			// 一些必要的清理工作
			if(server != null) {
				System.out.println("服务器已关闭。");
				server.close();
				server = null;
			}
		}
	}

	public static void main(String[] args) {
		try {
			ServerBetter.start();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}