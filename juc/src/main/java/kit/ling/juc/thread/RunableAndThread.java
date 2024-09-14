package kit.ling.juc.thread;

/**
 * The type Runable and thread.
 * 创建线程的两种方式
 */
public class RunableAndThread {


    /**
     * The type Based thread.
     */
    static class BasedThread extends Thread {
        @Override
        public void run() {
            System.out.println("继承thread实现的线程");

        }
    }

    /**
     * The type Based runnable.
     */
    static class BasedRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("实现runnable接口实现的线程");

        }
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        BasedRunnable t1 = new BasedRunnable();
        BasedThread t2 = new BasedThread();

        t2.start();


        // 最后的执行，还是要丢给 类（thread），必经接口没法直接操作呀。
        new Thread(t1).start();
    }


}
