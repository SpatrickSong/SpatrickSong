package com.beyondsoft.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @JmsListener(destination = "myqueues")
    public void receiveMsg(String text){
        System.out.println(text + ".....");
    }
}
