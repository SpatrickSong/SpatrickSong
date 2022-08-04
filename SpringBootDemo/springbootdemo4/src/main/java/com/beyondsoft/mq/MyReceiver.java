package com.beyondsoft.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyReceiver {
    @RabbitHandler
    @RabbitListener(queues = "hel")  //监听消息
    public void receive(String text){
        System.out.println("收到消息:" + text);
    }
}
