package com.base.cglibproxy;
public class Use {
    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);

        aliSmsService.send("java");
        //

    }
}
