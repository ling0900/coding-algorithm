package com.base01.cglibproxy;
public class Use {
    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);

        aliSmsService.send("java");
        //

    }
}
