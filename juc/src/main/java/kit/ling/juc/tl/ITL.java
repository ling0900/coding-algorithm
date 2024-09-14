package kit.ling.juc.tl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 作用是验证ThreadLocal的继承性，
 * 如果父线程设置了值，子线程可以获取到，如果子线程设置了值，父线程不可以获取到。
 *
 */
public class ITL {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(ITL.class);

        logger.info("======");

        InheritableThreadLocal<Integer> integerInheritableThreadLocal = new InheritableThreadLocal<>();
        integerInheritableThreadLocal.set(1);
        System.out.println(integerInheritableThreadLocal.get());

        Thread thread = new Thread(() -> {
            System.out.println(integerInheritableThreadLocal.get());
            integerInheritableThreadLocal.set(2);
            System.out.println(integerInheritableThreadLocal.get());
        });

        thread.start();
        thread.join();
        System.out.println(integerInheritableThreadLocal.get());

        integerInheritableThreadLocal.set(3);

        Thread thread1 = new Thread(() -> {
            System.out.println(integerInheritableThreadLocal.get());
        });

        thread1.start();
        thread1.join();


        System.out.println(integerInheritableThreadLocal.get());
    }
}
