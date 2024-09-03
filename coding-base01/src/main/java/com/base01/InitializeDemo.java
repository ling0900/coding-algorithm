package com.base01;

public class InitializeDemo {
    private static int k = 1;
    //private static InitializeDemo t1 = new InitializeDemo("t1");
    //private static InitializeDemo t2 = new InitializeDemo("t2");
    private static int i;
    private static int n = 99;

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
    public static void main(String args[]) {
        new InitializeDemo("init");
    }
}
