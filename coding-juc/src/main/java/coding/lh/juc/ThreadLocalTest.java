package coding.lh.juc;

import org.redisson.Redisson;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal<>();

        threadLocal.set(Integer.valueOf(1));

        threadLocal.get();
    }
}
