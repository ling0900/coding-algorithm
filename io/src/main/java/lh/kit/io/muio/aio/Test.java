package lh.kit.io.muio.aio;
import java.util.Scanner;
import lh.kit.io.muio.aio.client.AioClient;
import lh.kit.io.muio.aio.server.AioServer;

/**
 * 测试方法
 *
 * @author lh
 * @version 1.0
 */
public class Test {
	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception{
		//运行服务器
		AioServer.start();
		//避免客户端先于服务器启动前执行代码
		Thread.sleep(100);
		//运行客户端
		AioClient.start();
		System.out.println("请输入请求消息：");
		Scanner scanner = new Scanner(System.in);
		while (AioClient.sendMsg(scanner.nextLine())
		) {
			;
		}
	}
}