package com.base.res;

/**
 * 这段代码定义了一个名为Resource的类，实现了AutoCloseable接口。
 * 该类具有一个doSome方法用于执行某些操作，并且实现了close方法用于关闭资源。
 * 在main方法中，首先创建了一个Resource对象res。
 * 然后，在try块中调用res对象的doSome方法，执行一些操作。
 * 如果在执行过程中发生异常，会被catch块捕获，并打印异常堆栈信息。
 * 这段代码的目的是展示如何使用AutoCloseable接口和异常处理机制来确保资源的正确关闭。
 * 通过实现AutoCloseable接口，并在close方法中定义资源的关闭逻辑，
 * 可以在使用完资源后自动调用close方法进行资源释放。
 * 同时，通过使用try-catch块来捕获异常，可以在发生异常时进行相应的处理，避免程序崩溃或资源泄漏。
 */
class Resource implements AutoCloseable {
    void doSome() {
        System.out.println("do something");
    }
    @Override
    public void close() throws Exception {
        System.out.println("resource is closed");
    }

    public static void main(String[] args) {
        // 创建Resource对象
        try {
            Resource res = new Resource();
            // 调用doSome方法
            res.doSome();
        } catch(Exception ex) {
            // 捕获异常并打印异常堆栈信息
            ex.printStackTrace();
        }
    }
}