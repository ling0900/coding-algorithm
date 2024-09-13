package com.base.jdkproxy;

public class UseTest {
    public static void main(String[] args) {
        XxxService smsService = (XxxService) JdkProxyFactory.getProxy(new XxxServiceImpl());

        smsService.send("java");

    }
}
