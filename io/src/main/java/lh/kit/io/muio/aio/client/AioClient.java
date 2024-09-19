package lh.kit.io.muio.aio.client;
import java.util.Scanner;

/**
 * The type Client.
 */
public class AioClient {
	private static String DEFAULT_HOST = "127.0.0.1";
	private static int DEFAULT_PORT = 12345;
	private static AsyncClientHandler clientHandle;

	/**
	 * Start.
	 */
	public static void start(){
		start(DEFAULT_HOST,DEFAULT_PORT);
	}

	/**
	 * Start.
	 *
	 * @param ip   the ip
	 * @param port the port
	 */
	public static synchronized void start(String ip,int port){
		if(clientHandle!=null)
			return;
		clientHandle = new AsyncClientHandler(ip,port);
		new Thread(clientHandle,"Client").start();
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
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 * @throws Exception the exception
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{
		AioClient.start();
		System.out.println("请输入请求消息：");
		Scanner scanner = new Scanner(System.in);
		while(AioClient.sendMsg(scanner.nextLine()));
	}
}