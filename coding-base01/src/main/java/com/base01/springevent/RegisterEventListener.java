package com.base01.springevent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RegisterEventListener {

    @EventListener(RegisterSuccessEvent.class)
    public void onEvent(RegisterSuccessEvent event) {
        Object source = event.getSource();

    }
}
