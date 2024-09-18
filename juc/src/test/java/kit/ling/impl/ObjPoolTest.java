package kit.ling.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjPoolTest {
    @Test
    public void test() throws InterruptedException {
        // 创建对象池
        ObjPool<Integer, String> pool =
                new ObjPool<Integer, String>(10, 2);
        // 通过对象池获取t，之后执行
        pool.exec(t -> {
            System.out.println(t);
            return t.toString();
        });
    }
}