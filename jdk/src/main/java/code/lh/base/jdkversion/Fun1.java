package kit.ling.jdkversion;

@FunctionalInterface
public interface Fun1 {
    //在Java中，函数式接口（Functional Interface）是只包含一个抽象方法的接口。
    // 这个概念是Java 8引入的，用于支持Lambda表达式和方法引用。
    // 函数式接口也可以有多个默认方法（default methods）和静态方法（static methods），但只能有一个抽象方法。
    void doThing();

    default void s1() {

    }

    default void s2() {

    }
}
