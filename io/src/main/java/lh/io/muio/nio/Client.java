package lh.io.muio.nio;

/**
 * The type Client.
 */
public class Client {
	private static ClientHandle clientHandle;

	/**
	 * Start.
	 */
	public static void start(){
		String DEFAULT_HOST = "127.0.0.1";
		int DEFAULT_PORT = 12345;
		start(DEFAULT_HOST, DEFAULT_PORT);
	}

	/**
	 * Start.
	 *
	 * @param ip   the ip
	 * @param port the port
	 */
	public static synchronized void start(String ip,int port){
		if(clientHandle!=null)
			clientHandle.stop();
		clientHandle = new ClientHandle(ip,port);
		new Thread(clientHandle,"Server").start();
	}

	/**
	 * Send msg boolean.
	 *
	 * @param msg the msg
	 * @return the boolean
	 * @throws Exception the exception
	 */
	//向服务器发送消息
	public static boolean sendMsg(String msg) throws Exception{
		if(msg.equals("q")) return false;
		clientHandle.sendMsg(msg);
		return true;
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