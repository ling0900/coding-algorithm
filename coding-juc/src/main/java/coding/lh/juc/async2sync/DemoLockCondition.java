package coding.lh.juc.async2sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 利用锁：lock实现的异步转同步
 * @author menglinghao
 */
public class DemoLockCondition extends BaseDemo {

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    @Override
    public void callback(long response) {

        System.out.println("得到结果");
        System.out.println(response);
        System.out.println("调用结束");
        lock.lock();
        try {
            condition.signal();
        }finally {
            lock.unlock();
        }

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        DemoLockCondition demo2 = new DemoLockCondition();

        demo2.call();

        demo2.lock.lock();

        try {
            demo2.condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            demo2.lock.unlock();
        }
        System.out.println("主线程内容");
    }
}