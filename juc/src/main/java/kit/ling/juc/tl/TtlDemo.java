package kit.ling.juc.tl;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TtlDemo {

    // 创建 TransmittableThreadLocal 实例
    private static final TransmittableThreadLocal<String> context = new TransmittableThreadLocal<>();
    // 创建普通的 ThreadLocal 实例
    private static final ThreadLocal<String> context2 = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        // 创建一个线程池，并包装为 TTL 线程池
        ExecutorService executorService = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(2));

        // 主线程设置上下文值
        context.set("Parent Thread Context");
        // 主线程设置上下文值-普通
        context2.set("p-2");

        // 提交第一个任务
        executorService.submit(() -> {
            // 子线程可以继承父线程的上下文
            System.out.println("Task 1: " + context.get());
            System.out.println("Task 1: " + context2.get());
        });

        // 修改主线程的上下文值
        context.set("Updated Parent Thread Context");
        context.set("updated 2");

        // 提交第二个任务
        executorService.submit(() -> {
            // 子线程可以继承最新的上下文
            System.out.println("Task 2: " + context.get());
            System.out.println("Task 2: " + context2.get());
        });

        // 关闭线程池
        executorService.shutdown();
    }
}
