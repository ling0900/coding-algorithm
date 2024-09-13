package com.base.jdkproxy;

public class XxxServiceImpl implements XxxService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}

