package kit.ling.juc.tl;

/**
 * @author ling
 * @date 2022/10/26 11:15
 * @description ThreadLocalTest
 * @since 1.0.0
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        // 主线程
        threadLocal.set("0");
        System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
        threadLocal.remove();

        // 线程1
        new Thread(() -> {
            System.out.println("尝试获取主线程的值：" + threadLocal.get());
            threadLocal.set("1");
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
            threadLocal.remove();
        }, "t1").start();

        new Thread(() -> {
            threadLocal.set("2");
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
            threadLocal.remove();
        }, "t2").start();

    }
}
