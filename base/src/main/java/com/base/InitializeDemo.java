package com.base;

public class InitializeDemo {
    private static int i;
    private static int k = 1;
    private static int n = 10;

    private int h = print("------------静态方法（属性）order_1------------");

    static {
        print("------------静态块------------");
    }

    private int j = print("------------静态方法（属性）------------");

    {
        print("------------构造块------------");
    }

    public InitializeDemo(String str) {
        print("------------构造方法------------");
    }

    public static int print(String str) {
        System.out.println(str);
        System.out.println("k=" + k);
        System.out.println((k++) + ":" + "   i=" + i + "    n=" + n);
        n++;
        return ++i;
    }

}
