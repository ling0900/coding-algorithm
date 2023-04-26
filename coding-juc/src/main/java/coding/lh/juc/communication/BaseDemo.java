package coding.lh.juc.communication;

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
     *
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
