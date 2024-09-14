package kit.ling.juc.async2sync;

/**
 * The type Demo 1.
 * @author menglinghao
 * 用的synchronize这个锁实现的
 */
public class DemoTest extends BaseDemo{

    private final Object lock = new Object();

    private String asyResponse;

    @Override
    public void callback(long response) {
        this.asyResponse = "" + response;

        synchronized (lock) {
            System.out.println("调用结束了，所以现在去唤醒调用方");
            lock.notifyAll();
        }

    }

    /**
     * The entry point of application.
     * 异步转同步的测试方法！
     * @param args the input arguments
     */
    public static void main(String[] args) {

        DemoTest demo1 = new DemoTest();

        // 发起远程调用
        System.out.println("发起远程调用");
        demo1.call();

        synchronized (demo1.lock){
            try {
                System.out.println("发起线程调用wait（）,释放锁资源的同时，等待被notify");
                demo1.lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("异步调用，同步转异步后的结果是：" + demo1.asyResponse);

    }
}