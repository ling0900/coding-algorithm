package kit.ling.cas.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CasLockTest {

    // 自旋锁
    private final CasLock casLock = new CasLock();
    // 计数器
    private long count = 0;

    /**
     * 自旋锁实现计数器
     */
    public void increment() {
        try {
            casLock.lock();
            count++;
        } finally {
            casLock.unlock();
        }
    }

    /**
     * 获取计数器值
     * @return 计数器值
     */
    public long getCount() {
        return count;
    }

    @Test
    void TestLockAndUnlock() {
        CasLockTest casLockTest = new CasLockTest();

        // 创建两个线程，每个线程执行10000次自增操作
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                casLockTest.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                casLockTest.increment();
            }
        });

        // 启动两个线程
        thread1.start();
        thread2.start();

        // 等待两个线程执行完毕
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 验证计数器的值是否为20000
        assertEquals(20000, casLockTest.getCount());
    }

}