package coding.lh.juc.thread;

/**
 * The type My thread.
 * run 方法封装了线程执行的代码
 * 简单线程的创建
 * @author menglinghao
 */
public class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "输出" + i + "次");
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        HelloThread helloThread1 = new HelloThread();
        HelloThread helloThread2 = new HelloThread();

        helloThread.setName("张三");
        helloThread1.setName("李四");
        helloThread2.setName("王五");

        helloThread.start();
        helloThread1.start();
        // 思考下start方法都是做了什么？
        helloThread2.start();

    }
}
