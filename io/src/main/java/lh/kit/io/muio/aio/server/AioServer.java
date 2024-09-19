package lh.kit.io.muio.aio.server;

/**
 * AIO服务端
 *
 * @author lh
 * @version 1.0
 */
public class AioServer {
	private static AsyncServerHandler serverHandle;
	/**
	 * The constant clientCount.
	 */
	public volatile static long clientCount = 0;

	/**
	 * Start.
	 */
	public static void start(){
		int DEFAULT_PORT = 12345;
		start(DEFAULT_PORT);
	}

	/**
	 * Start.
	 *
	 * @param port the port
	 */
	public static synchronized void start(int port){
		if(serverHandle!=null)
			return;
		serverHandle = new AsyncServerHandler(port);
		new Thread(serverHandle,"Server").start();
	}

	/**
	 * Main.
	 *
	 * @param args the args
	 */
	public static void main(String[] args){
		AioServer.start();
	}
}