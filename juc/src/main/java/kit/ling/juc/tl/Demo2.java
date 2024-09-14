package kit.ling.juc.tl;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 代码来自于：
 * https://github.com/alibaba/transmittable-thread-local/issues/53
 */
public class Demo2 {
    ExecutorService service = Executors.newFixedThreadPool(1);
    ExecutorService executorService = TtlExecutors.getTtlExecutorService(service);

    // 通过`TransmittableThreadLocal`变量查看/修改的自己线程的哪个拷贝
// 所以命名 不用Parent，往往按用途命名
// 且是 static 变量
    static final TransmittableThreadLocal<String> storeTestContext = new TransmittableThreadLocal<String>();

    public void testMethod() throws InterruptedException {
        storeTestContext.set("value-set-in-parent");
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                // 继承自testMethod方法所在线程
                System.out.println("Before set in Runnable: " + storeTestContext.get());
                storeTestContext.set("asf");
                // 设置新值，不会影响testMethod线程
                System.out.println("After set in Runnable: " + storeTestContext.get());
            }
        });
        Thread.sleep(1000);
        String value = storeTestContext.get();
        System.out.println("In testMethod: " + value);
    }

    public static void main(String[] args) throws InterruptedException {
        Demo2 demo2 = new Demo2();
        demo2.testMethod();
    }


}
