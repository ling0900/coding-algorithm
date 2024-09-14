package com.base.springevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private ApplicationContext applicationContext;

    public void register(String s) {

        applicationContext.publishEvent(new RegisterSuccessEvent(s));

    }
}
