package lh.kit.io.muio.aio.client;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

/**
 * The type Read handler.
 */
public class ReadHandler implements CompletionHandler<Integer, ByteBuffer> {
	private final AsynchronousSocketChannel clientChannel;
	private final CountDownLatch latch;

	/**
	 * Instantiates a new Read handler.
	 *
	 * @param clientChannel the client channel
	 * @param latch         the latch
	 */
	public ReadHandler(AsynchronousSocketChannel clientChannel,CountDownLatch latch) {
		this.clientChannel = clientChannel;
		this.latch = latch;
	}

	@Override
	public void completed(Integer result,ByteBuffer buffer) {
		buffer.flip();
		byte[] bytes = new byte[buffer.remaining()];
		buffer.get(bytes);
		String body;
		body = new String(bytes, StandardCharsets.UTF_8);
		System.out.println("客户端收到结果:"+ body);
	}

	@Override
	public void failed(Throwable exc,ByteBuffer attachment) {
		System.err.println("数据读取失败...");
		try {
			clientChannel.close();
			latch.countDown();
		} catch (IOException ignored) {
		}
	}
}