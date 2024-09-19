package lh.kit.io.muio.bio;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import lh.kit.io.utils.Calculator;

/**
 *
 * @author lh
 */
public class ServerHandler implements Runnable{
	private Socket socket;

	/**
	 * Instantiates a new Server handler.
	 *
	 * @param socket the socket
	 */
	public ServerHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		BufferedReader in = null;
		PrintWriter out = null;

		try{
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(),true);
			String expression;
			String result;
			while (true) {
				if((expression = in.readLine())==null) break;
				System.out.println("内容是：" + expression);
				try{
					result = Calculator.Instance.cal(expression).toString();
				}catch(Exception e){
					result = "结果是：" + e.getMessage();
				}
				out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
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