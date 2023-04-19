package com.lh.juc.juc.juc_000thread;

/**
 * The type T 02 how to create thread.
 */
public class T02_HowToCreateThread {
    /**
     * The type My thread.
     * 通过继承 thread 来实现 一个线程
     */
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyThread!");
        }
    }

    /**
     * The type My run.
     * 继承 runnable接口实现一个线程
     */
    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        new Thread(()->{
            System.out.println("Hello Lambda!");
        }).start();
    }

}

// 启动线程的三种方式 1：Thread 2: Runnable 3:Executors.newCachedThrad
