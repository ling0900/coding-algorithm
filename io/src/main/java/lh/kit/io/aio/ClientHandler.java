package lh.kit.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;

public class ClientHandler implements CompletionHandler<Integer, ByteBuffer> {
    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        buffer.flip();
        byte [] data = new byte[buffer.remaining()];
        buffer.get(data);
        System.out.println(Thread.currentThread().getName() + " received:"  + new String(data, StandardCharsets.UTF_8));
    }

    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {

    }
}