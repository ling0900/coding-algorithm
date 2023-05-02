package coding.lh.juc.communication;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * The type Async call demo.
 * 异步调用的类
 * @author menglinghao
 */
public class AsyncCallDemo {

    private Random random = new Random(System.currentTimeMillis());

    private ExecutorService tp = Executors.newSingleThreadExecutor();

    /**
     * Call.
     * 异步调用的方法call
     * @param demo the demo
     */
    public void call(BaseDemo demo){

        new Thread(()->{
            long res = random.nextInt(10);

            try {
                System.out.println("异步调用，模拟业务执行流程，睡几秒～～");
                Thread.sleep(res*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.callback(res);
        }).start();
    }

    /**
     * Future call future.
     *
     * @return the future
     */
    public Future<Long> futureCall(){

        return tp.submit(()-> {
            long res = random.nextInt(10);

            try {
                Thread.sleep(res*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return res;
        });
    }

    /**
     * Shutdown.
     */
    public void shutdown(){
        tp.shutdown();
    }

}
