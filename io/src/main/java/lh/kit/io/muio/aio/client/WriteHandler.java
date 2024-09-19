package lh.kit.io.muio.aio.client;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * The type Write handler.
 */
public class WriteHandler implements CompletionHandler<Integer, ByteBuffer> {
	private final AsynchronousSocketChannel clientChannel;
	private final CountDownLatch latch;

	/**
	 * Instantiates a new Write handler.
	 *
	 * @param clientChannel the client channel
	 * @param latch         the latch
	 */
	public WriteHandler(AsynchronousSocketChannel clientChannel,CountDownLatch latch) {
		this.clientChannel = clientChannel;
		this.latch = latch;
	}

	@Override
	public void completed(Integer result, ByteBuffer buffer) {
		//完成全部数据的写入
		if (buffer.hasRemaining()) {
			clientChannel.write(buffer, buffer, this);
		} else {
			//读取数据
			ByteBuffer readBuffer = ByteBuffer.allocate(1024);
			clientChannel.read(readBuffer,readBuffer,new ReadHandler(clientChannel, latch));
		}
	}

	@Override
	public void failed(Throwable exc, ByteBuffer attachment) {
		System.err.println("数据发送失败...");
		try {
			clientChannel.close();
			latch.countDown();
		} catch (IOException e) {
		}
	}
}