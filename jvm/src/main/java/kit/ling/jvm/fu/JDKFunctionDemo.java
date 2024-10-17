package kit.ling.jvm.fu;

import java.util.function.Supplier;

/**
 * Supplier 主要用于延迟计算或惰性求值的场景，它可以用来生成或提供一些值，而不需要立即执行计算。
 * 这在某些情况下可以提高性能，避免不必要的计算开销。
 */
public class JDKFunctionDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello Supplier";
        System.out.println(supplier.get());
    }
}
