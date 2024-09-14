package coding.lh;

import java.util.concurrent.*;

/**
 * 当线程池满了且线程池的RejectedExecutionHandler使用的是CallerRunsPolicy时，提交到线程池的任务会在提交线程中直接执行，
 * ThreadLocal.remove操作清理提交线程的上下文导致上下文丢失。
 *
 */
public class ThreadLocalIssueExample {

    // 定义一个ThreadLocal变量，用来保存上下文信息
    private static ThreadLocal<String> threadLocalContext = new ThreadLocal<>();

    public static void main(String[] args) {
        // 创建线程池，核心线程数和最大线程数设置为1，队列大小为1
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1, 1, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.CallerRunsPolicy()
        );

        // 向线程池提交两个任务，第一个任务将在线程池中执行
        for (int i = 1; i <= 2; i++) {
            String context = "Task " + i;
            threadLocalContext.set(context); // 设置上下文信息
            executor.submit(() -> runTask(context));
            //threadLocalContext.remove(); // 清理提交线程的上下文
        }

        executor.shutdown();
    }

    private static void runTask(String taskContext) {
        System.out.println("Running task with context: " + threadLocalContext.get());
        // 执行任务时尝试访问ThreadLocal上下文
        if (threadLocalContext.get() == null) {
            System.out.println("Context is lost for " + taskContext);
        } else {
            System.out.println("Context for " + taskContext + ": " + threadLocalContext.get());
        }
    }
}

