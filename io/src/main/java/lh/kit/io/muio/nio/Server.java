package lh.kit.io.muio.nio;

/**
 * The type Server.
 */
public class Server {
	private static ServerHandle serverHandle;

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
			serverHandle.stop();
		serverHandle = new ServerHandle(port);
		new Thread(serverHandle,"Server").start();
	}

	/**
	 * Main.
	 *
	 * @param args the args
	 */
	public static void main(String[] args){
		start();
	}
}