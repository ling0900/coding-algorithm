package com.base.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHello {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogHello.class);
        System.out.println();
        // logger.info("Hello") 和 System.out.println("hello")最后都是定位到 PrintStream 的同一个方法。
        // 思考：日志从哪里直接打印到具体的磁盘呢？
        // 这里为何用到的是字节流呢？
        System.out.println("hello");
        logger.info("Hello");

    }
}
