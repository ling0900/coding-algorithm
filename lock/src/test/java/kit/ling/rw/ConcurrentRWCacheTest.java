package kit.ling.rw;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class ConcurrentRWCacheTest {

    // 创建一个ConcurrentRWCache对象
    private ConcurrentRWCache<String, String> cache = new ConcurrentRWCache<>();

    @Test
    public void testGetAndPut() {
        IntStream.range(0, 6).forEach(
                i -> {
                    new Thread(() -> {
                        cache.put("key" + i, "value" + i);
                    }).start();
                }
        );

        IntStream.range(0, 6).forEach(
                i -> {
                    new Thread(() -> {
                        cache.get("key" + i);
                    }).start();
                }
        );

    }


}