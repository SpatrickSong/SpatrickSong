package com.beyondsoft;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * HAProxy连接RabbitMQ集群发送消息，实现负载均衡
 */
public class Demo {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1.创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2.设置参数
        factory.setHost("172.16.68.133");//HAProxy的ip
        factory.setPort(5672);//HAProxy监听的端口
        //3.创建连接 Connection
        Connection connection = factory.newConnection();
        //4.创建 Channel
        Channel channel = connection.createChannel();
        //5.创建队列Queue
        channel.queueDeclare("hello world",true,false,false,null);
        String body = "hello rabbitmq....";
        //6.发送消息
        channel.basicPublish("","hello_world",null,body.getBytes());
        //7.释放资源
        channel.close();
        connection.close();
        System.out.println("send success....");
    }
}
