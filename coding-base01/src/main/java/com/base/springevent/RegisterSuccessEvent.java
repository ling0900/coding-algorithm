package com.base.springevent;

import org.springframework.context.ApplicationEvent;

public class RegisterSuccessEvent extends ApplicationEvent {
    public RegisterSuccessEvent(Object source) {
        super(source);
    }
}
