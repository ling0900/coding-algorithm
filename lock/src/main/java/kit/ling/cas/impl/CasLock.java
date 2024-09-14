package kit.ling.cas.impl;

import kit.ling.cas.ILock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ling
 * @date 2022/10/14
 * @description 自旋锁实现类
 * @since 1.0.0
 */
public class CasLock implements ILock {

    /**
     * 创建一个原子引用，用来存储当前线程的信息
     */
    private AtomicReference<Thread> curThreadOwner = new AtomicReference<>();

    @Override
    public void lock() {

        // 获取当前线程的对象
        Thread currentThread = Thread.currentThread();

        // 自旋锁，如果当前线程的原子引用不为空，则继续自旋
        for (;;) {
            // 如果当前线程的原子引用为空，则将当前线程的信息设置到原子引用中
            if (curThreadOwner.compareAndSet(null, currentThread)) {
                return;
            }

        }

    }

    @Override
    public void unlock() {

        // 获取当前线程的对象
        Thread currentThread = Thread.currentThread();

        // 如果当前线程的原子引用不为空，则将当前线程的信息设置为空
        if (curThreadOwner.compareAndSet(currentThread, null)) {
            return;
        }

    }
}
