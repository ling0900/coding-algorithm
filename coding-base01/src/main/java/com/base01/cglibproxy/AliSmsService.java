package com.base01.cglibproxy;


import java.util.concurrent.BlockingDeque;

public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}

