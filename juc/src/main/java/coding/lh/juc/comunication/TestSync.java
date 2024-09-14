package coding.lh.juc.comunication;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Test sync.
 */
public class TestSync {

    /**
     * The constant notice.
     */
//定义共享变量来实现通信，它需要volatile修饰，否则线程不能及时感知
    static volatile boolean notice = false;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //线程A
        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                list.add("abc");
                System.out.println("线程A添加元素，此时list的size为：" + list.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.size() == 5) {
                    notice = true;
                }
            }
        });
        //线程B
        Thread threadB = new Thread(() -> {
            while (true) {// 这个代码非常消耗资源。
                if (notice) {// a线程对此变量做了修改，这个线程可以立马感知到
                    System.out.println("线程B收到通知，开始执行自己的业务...");
                    break;
                }
            }
        });
        //需要先启动线程B
        threadB.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 再启动线程A
        threadA.start();
    }
}