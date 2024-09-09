package com.base01;

public class InitializeDemo2 {
    private static int k = 1;
    private static int n = 10;
    private static int i;
    private String s = new String("-----");

    static {
        System.out.println("静态代码块：执行了");
        System.out.println("k=" + k + ", n=" + n + ", i=" + i);
    }

    private int h = 2;

    {
        System.out.println("普通代码块：执行了");
        System.out.println(s);
    }

    public static void m1() {
        System.out.println("静态方法：执行了");
        System.out.println("k=" + (k++) + ", n=" + n + ", i=" + i);
    }

    public void m2() {
        System.out.println("普通方法：执行了");
        System.out.println("k=" + (k++) + ", n=" + n + ", i=" + i);
    }


    public InitializeDemo2(String str) {
        System.out.println("构造器：执行了");
        System.out.println("k=" + (k++) + ", n=" + n + ", i=" + i);
    }

}
