package coding.lh.juc.thread;

import java.util.concurrent.Callable;

public class HelloCallableThread implements Callable {
    @Override
    public Object call() throws Exception {
        return "hello callable thread";
    }


    public static void main(String[] args) {
        HelloCallableThread callableThread = new HelloCallableThread();


        try {
            Object call = callableThread.call();
            System.out.println(call);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
