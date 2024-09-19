package lh.kit.io.muio.bio;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 阻塞式I/O创建的客户端
 *
 * @author lh
 * @version 1.0
 */
public class AioClient {

	//默认的端口号
	private static final int DEFAULT_SERVER_PORT = 9996;
	private static final String DEFAULT_SERVER_IP = "127.0.0.1";

	/**
	 * Send.
	 *
	 * @param expression the expression
	 */
	public static void send (String expression){
		send(DEFAULT_SERVER_PORT,expression);
	}


	/**
	 * Send.
	 *
	 * @param port       the port
	 * @param expression the expression
	 */
	public static void send (int port,String expression) {

		System.out.println("算术表达式为：" + expression);

		Socket socket = null;

		/*
		 * Reads text from a character-input stream, buffering characters
		 * so as to provide for the efficient reading of characters, arrays, and lines.
		 * reader 主要读取字符
		 * writer 主要是写
		 * 都站在内存的角度
		 * 看见Input或Reader就代表，你现在所使用的流是输入流【是一个（硬盘==》内存）的过程】
		 * 看见Output或Writer就代表，你现在使用的流是输出流【是一个（内存==》硬盘）的过程】
		 */
		BufferedReader in = null;
		PrintWriter out = null;

		try {
			socket = new Socket(DEFAULT_SERVER_IP,port);
			// inputStream 转 reader
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
			out.println(expression);
			System.out.println("结果为：" + in.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
//				in = null;
			}
			if (out != null) {
				out.close();
			}
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}