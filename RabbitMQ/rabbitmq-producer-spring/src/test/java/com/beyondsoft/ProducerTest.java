package com.beyondsoft;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-producer.xml")
public class ProducerTest {
    //1.注入RabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void testHelloWorld(){
        //2.发送消息
        rabbitTemplate.convertAndSend("spring_queue","hello world spring....");
    }

    /**
     * 发的fanout消息
     */
    @Test
    public void testFanout(){
        //2.发送消息
        rabbitTemplate.convertAndSend("spring_fanout_exchange","","spring fanout....");
    }

    /**
     * 发的topic消息
     */
    @Test
    public void testTopic(){
        //2.发送消息
        rabbitTemplate.convertAndSend("spring_topic_exchange","heima.hehe.heihei","spring topic....");
    }
}
