package lh.kit.io.muio.bio;
import java.io.IOException;
import java.util.Random;

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
	 * @throws InterruptedException the interrupted exception
	 */
	public static void main(String[] args) throws InterruptedException {

		//运行服务器
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ServerBetter.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		thread.start();


		//避免客户端先于服务器启动前执行代码
		Thread.sleep(100);
		//运行客户端
		final char[] operators = {'+','-','*','/'};
		final Random random = new Random(System.currentTimeMillis());

		new Thread(new Runnable() {
			@SuppressWarnings("static-access")
			@Override
			public void run() {
				while(true){
					//随机产生算术表达式
					String expression = random.nextInt(10)+""+operators[random.nextInt(4)]+(random.nextInt(10)+1);
					AioClient.send(expression);
					try {
						Thread.currentThread().sleep(random.nextInt(1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}