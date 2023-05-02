package coding.lh.juc.async2sync;

/**
 * The type Base demo.
 * @author menglinghao
 */
public abstract class BaseDemo {

    /**
     * The Async call.
     */
    protected AsyncCallDemo asyncCall = new AsyncCallDemo();

    /**
     * Callback.
     * 这个回调方法里面主要是用来实现一个操作：通知调用方，线程通信的机制。
     * @param response the response
     */
    public abstract void callback(long response);

    /**
     * Call.
     */
    public void call(){
        System.out.println("发起调用");
        asyncCall.call(this);
        System.out.println("调用返回");
    }

}
