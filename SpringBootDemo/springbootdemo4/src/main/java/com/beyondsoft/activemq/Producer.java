package com.beyondsoft.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    //发送消息
    public void sendMessage(Destination des,String message){
        jmsTemplate.convertAndSend(des,message);
    }
}
