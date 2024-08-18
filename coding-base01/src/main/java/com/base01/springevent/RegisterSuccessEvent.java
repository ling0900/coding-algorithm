package com.base01.springevent;

import org.springframework.context.ApplicationEvent;

public class RegisterSuccessEvent extends ApplicationEvent {
    public RegisterSuccessEvent(Object source) {
        super(source);
    }
}
