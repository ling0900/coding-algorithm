package kit.ling.cas;

/**
 * @author ling
 * @date 2022/10/14
 * @description 自旋锁接口
 * @since 1.0.0
 */
public interface ILock {

    /**
     * 获取锁
     */
    void lock();

    /**
     * 释放锁
     */
    void unlock();
}
