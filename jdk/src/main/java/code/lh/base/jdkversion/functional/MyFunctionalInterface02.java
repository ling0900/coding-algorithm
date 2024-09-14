package code.lh.base.jdkversion.functional;

import java.util.function.Function;

@FunctionalInterface
public interface MyFunctionalInterface02 {
    int doSomething(int n);  // 抽象方法

    // 可以有默认方法
    default void defaultMethod() {
        System.out.println("This is a default method");
    }

    default void defaultMethod2(String s) {
        System.out.println("This is a default method" + s);
    }

    // 可以有静态方法
    static void staticMethod() {
        System.out.println("This is a static method");
    }


    public static void main(String[] args) {
        MyFunctionalInterface02 myFunc = (n) -> n;
        int i = myFunc.doSomething(2);// 输出: Doing something!
        System.out.println(i);

        myFunc.defaultMethod2("method 2");

        myFunc.defaultMethod();  // 输出: This is a default method
        MyFunctionalInterface02.staticMethod();  // 输出: This is a static method


        // JDK8提供的
        Function<String, Integer> stringLength = (str) -> str.length();
        int length = stringLength.apply("Hello, World!");  // length是13
        System.out.println(length);
    }
}

