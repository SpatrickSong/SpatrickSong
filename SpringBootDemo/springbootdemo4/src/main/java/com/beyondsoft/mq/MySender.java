package com.beyondsoft.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MySender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        //在RabbitMq中创建队列hel，这样消息就会发送到该队列当中
        rabbitTemplate.convertAndSend("hel","你好");
    }
}
