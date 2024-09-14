package kit.ling.jdkversion.functional;

@FunctionalInterface
public interface MyFunctionalInterface {
    void doSomething();  // 抽象方法

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
        MyFunctionalInterface myFunc = () -> System.out.println("Doing something!");
        myFunc.doSomething();  // 输出: Doing something!

        myFunc.defaultMethod2("method 2");

        myFunc.defaultMethod();  // 输出: This is a default method
        MyFunctionalInterface.staticMethod();  // 输出: This is a static method
    }
}

