package kit.ling.juc.async2sync;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * The type Demo 3.
 * 通过，future调用
 */
public class Demo3{

    private AsyncCallDemo asyncCall = new AsyncCallDemo();

    /**
     * Call future.
     *
     * @return the future
     */
    public Future<Long> call(){

        Future<Long> future = asyncCall.futureCall();

        asyncCall.shutdown();

        return future;

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Demo3 demo3 = new Demo3();

        System.out.println("发起调用");
        Future<Long> future = demo3.call();
        System.out.println("返回结果");

        while (!future.isDone() && !future.isCancelled());

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("主线程内容");

    }
}
