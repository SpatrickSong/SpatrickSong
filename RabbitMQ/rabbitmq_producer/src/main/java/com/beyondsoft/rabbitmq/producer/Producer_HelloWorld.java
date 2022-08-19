package com.beyondsoft.rabbitmq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 发送消息
 */
public class Producer_HelloWorld {
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
        channel.queueDeclare("hello_world",true,false,false,null);
        //6、发送消息
        /**
         * basicPublish(String exchange, String routingKey, BasicProperties props, byte[] body)
         * 1.exchange:交换机的名称，简单模式下会使用默认的
         * 2.routingKey：路由名称,如果使用默认的交换机，那么routingKey就要和队列的名称一样，才能路由到对应的队列中去
         * 3.props：配置信息
         * 4.body：发送的消息数据
         */
        String body = "hello rabbitmq------";
        channel.basicPublish("","hello_world",null,body.getBytes());
        //7、释放资源
        channel.close();
        connection.close();

    }
}
