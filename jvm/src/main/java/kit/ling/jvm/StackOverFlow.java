package kit.ling.jvm;

public class StackOverFlow {


    private static void re(int i) {
        re(i);
    }

    public static void main(String[] args) {
        // 栈溢出
        re(1);
    }
}
