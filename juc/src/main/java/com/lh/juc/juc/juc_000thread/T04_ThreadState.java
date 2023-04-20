package com.lh.juc.juc.juc_000thread;

public class T04_ThreadState {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("run方法内：" + this.getState());

            for(int i=0; i<3; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();

        System.out.println(t.getState());

        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println( "interrupt了");
            e.printStackTrace();
        }

        System.out.println(t.getState());

    }
}
