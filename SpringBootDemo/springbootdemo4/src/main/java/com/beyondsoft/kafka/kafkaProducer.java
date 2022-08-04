package com.beyondsoft.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

@Component
@EnableScheduling //开启定时任务
public class kafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    //使用定时任务，每个一秒发送一次消息
    @Scheduled(cron = "00/1 **** ?")
    public void send(){
        String msg = UUID.randomUUID().toString();
        ListenableFuture future =  kafkaTemplate.send("tests",msg);
        future.addCallback(o -> System.out.println("send--消息发送成功：" + msg),
                throwable -> System.out.println("消息发送失败：" + msg));

    }
}
