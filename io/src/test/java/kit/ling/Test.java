package kit.ling;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        AtomicInteger idx = new AtomicInteger();
        int length = 6;
        int tNum = 200;
        for (int m = 0; m < tNum; m++) {
            int i = idx.getAndIncrement() & (length - 1);
            System.out.println(i);
        }

        System.out.println("-----------");
        idx = new AtomicInteger();
        for (int m = 0; m < tNum; m++) {
            int j = (int) Math.abs(idx.getAndIncrement() % length);
            System.out.println(j);
        }


    }

    @org.junit.jupiter.api.Test
    public void math() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
