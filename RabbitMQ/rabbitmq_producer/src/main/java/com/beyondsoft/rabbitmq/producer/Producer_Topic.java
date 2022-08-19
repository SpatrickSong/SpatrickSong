package com.beyondsoft.rabbitmq.producer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 发送消息
 */
public class Producer_Topic {
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
        //5、创建交换机
        /**
         * exchangeDeclare(String exchange, BuiltinExchangeType type, boolean durable, boolean autoDelete, boolean internal, Map<String, Object> arguments)
         * 参数：
         *  1.exchange：交换机名称
         *  2.type：交换机类型
         *     DIRECT("direct")：定向
         *     FANOUT("fanout")：扇形（广播），发送消息到与之绑定的每一个队列
         *     TOPIC("topic")：通配符的方式
         *     HEADERS("headers")：参数匹配
         *  3.durable：是否持久化
         *  4.autoDelete：是否自动删除
         *  5.internal：mq内部使用，一般都是false
         *  6.arguments：参数
         */
        String exchangeName = "test_topic";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC,true,false,false,null);
        //6、创建队列
        String queue1Name = "test_topic_queue1";
        String queue2Name = "test_topic_queue2";
        channel.queueDeclare(queue1Name,true,false,false,null);
        channel.queueDeclare(queue2Name,true,false,false,null);
        //7、绑定队列和交换机(让交换机指定分发消息到哪个队列中)
        /**
         * queueBind(String queue, String exchange, String routingKey)
         * 参数：
         *  1.queue：队列名称
         *  2.exchange：交换机名称
         *  3.routingKey：路由键，绑定规则
         *      如果交换机的类型为fanout，routingKey设置为"",空字符串
         */
        /**
         * routing key由两部分组成，系统的名称.日志的级别
         * 需求：所有error、order级别的日志存数据库
         */

        channel.queueBind(queue1Name,exchangeName,"#.error");
        channel.queueBind(queue1Name,exchangeName,"order.*");
        channel.queueBind(queue2Name,exchangeName,"*.*");
       //8、发送消息
        String body = "日志信息:内存空间不足，需要扩容";
//        channel.basicPublish(exchangeName,"order.info",null,body.getBytes());
        channel.basicPublish(exchangeName,"goods.info",null,body.getBytes());
        //9、释放资源
        channel.close();
        connection.close();
    }
}
