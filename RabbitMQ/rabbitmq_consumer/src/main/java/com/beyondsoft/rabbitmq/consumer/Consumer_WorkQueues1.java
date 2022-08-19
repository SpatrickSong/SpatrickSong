package com.beyondsoft.rabbitmq.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 接收消息
 */
public class Consumer_WorkQueues1 {
    public static void main(String[] args) throws IOException, TimeoutException {
        //1、创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2、设置参数
        factory.setHost("127.0.0.1"); //设置IP地址，默认为localhost
        factory.setPort(5672);//默认5672
        //factory.setVirtualHost("/itcast");//设置虚拟机，默认值/
        //factory.setUsername("heima");//用户名，默认值guest
        //factory.setPassword("heima");//密码，默认值guest
        //3、创建连接connection
        Connection connection = factory.newConnection();
        //4、创建Channel
        Channel channel = connection.createChannel();
        //5、创建队列Queue

        /**
         * queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
         * 参数：
         *  1.queue：队列名称
         *  2.durable：是否持久化，当mq重启之后还在
         *  3.exclusive
         *      是否独占，只能有一个消费者监听队列
         *      当connection关闭时是否删除队列
         *  4.autoDelete是否自动删除，当没有Consumer时，自动删除
         *  5.arguments：参数信息
         */
        //如果没有一个名字叫hello world的队列，则会创建该队列，如果有则不会创建
        channel.queueDeclare("Work_queues",true,false,false,null);
        //6、接收消息
        /**
         * basicConsume(String queue, boolean autoAck, Consumer callback)
         * 1.queue:队列名称
         * 2.autoAck：是否自动确认，是确认是否收到消息
         * 3.callback：回调对象
         */
        Consumer consumer = new DefaultConsumer(channel){
            /**
             * 回调方法，当收到消息后会自动执行该方法
             * @param consumerTag：表示
             * @param envelope：获取一些信息，比如:交换机、路由key...
             * @param properties:配置信息
             * @param body：消息数据
             * @throws IOException
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
               /* System.out.println("consumerTag: " + consumerTag);
                System.out.println("exchange: " + envelope.getExchange());
                System.out.println("RoutingKey: " + envelope.getRoutingKey());
                System.out.println("properties: " + properties);*/
                System.out.println("body: " + new String(body));
            }
        };
        channel.basicConsume("Work_queues",true,consumer);
        //消费者不需要关闭资源
    }
}
