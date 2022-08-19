package com.beyondsoft;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-rabbitmq-producer.xml")
public class ProducerTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 确认模式
     * 步骤：
     *    1.开启确认模式：connectionFactory中开启publisher-confirms="true"
     *    2.在rabbitTemplate上定义ConfirmCallBack回调函数
     */
    @Test
    public void testConfirm() throws InterruptedException {
        //2.定义回调函数
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             *
             * @param correlationData 相关的配置信息
             * @param b exchange交换机是否成功收到消息。true代表成功,false代表失败
             * @param s 失败原因
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                System.out.println("confirm方法被执行了.....");
                if(b){
                    //接收成功
                    System.out.println("接收成功：" + s);
                }else{
                    //接收失败
                    System.out.println("接收失败：" + s);
                    //做一些处理，让消息再次发送
                }
            }
        });
        //3.发送消息
        rabbitTemplate.convertAndSend("test_exchange_confirm111","confirm","message confirm... ");
        //因为消息发送后方法结束，rabbitmq相关的资源也就关闭了，虽然我们的消息发送出去，但异步的ConfirmCallback却由于资源关闭而的问题
        Thread.sleep(2000);
    }

    /**
     *回退模式：当消息发送给Exchange后，Exchange路由到Queue失败时才会执行ReturnCaLlBack回调函数
     * 步骤：
     *  1.开启回退模式：publisher-returns="true"
     *  2.设置ReturnCaLlBack
     *  3.设置Exchange处理消息的模式
     *    1.如果消息没有路由到Queue，则丢弃消息（默认）
     *    2.如果消息没有路由到Queue，返回给消息的发送方ReturnCaLlBack
     */
    @Test
    public void testReturn() throws InterruptedException {
        //设置交换机处理失败消息的模式
        rabbitTemplate.setMandatory(true);
        //2.设置ReturnCaLlBack
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            /**
             *
             * @param message 发送的消息对象
             * @param replyCode 失败的错误码
             * @param replyTest 失败的错误信息
             * @param exchange 交换机
             * @param routingKey 路由键
             */
            @Override
            public void returnedMessage(Message message, int replyCode, String replyTest, String exchange, String routingKey) {
                System.out.println("return 执行了....");
                System.out.println(message);
                System.out.println(replyCode);
                System.out.println(replyTest);
                System.out.println(exchange);
                System.out.println(routingKey);
            }
        });
        //3.发送消息
        rabbitTemplate.convertAndSend("test_exchange_confirm","confirm","message confirm... ");

    }


    @Test
    public void testSend(){
        for (int i = 0; i <10 ; i++) {
            //发送消息
            rabbitTemplate.convertAndSend("test_exchange_confirm","confirm","message confirm... ");
        }
    }

    /**
     * 过期时间
     * 1、队列的统一过期
     * 2、消息的单独过期
     * 如果设置了消息的过期时间，也设置了队列的过期时间，它以时间短的为准。
     * 消息过期后，只有消息在队列顶端，才会判断其是否过期（移除掉）
     */
    @Test
    public void testTtl() {
        /*for (int i = 0; i <10 ; i++) {
            //发送消息
            rabbitTemplate.convertAndSend("test_exchange_ttl","ttl.message01","message ttl... ");
        }*/
        //消息单独过期
        //消息后处理对象，可以设置一些消息的参数信息
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor(){
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //1.设置message的信息
                message.getMessageProperties().setExpiration("5000");//消息的过期时间
                //2.返回消息
                return message;
            }
        };

        //rabbitTemplate.convertAndSend("test_exchange_ttl", "ttl.message01", "message ttl... ", messagePostProcessor);
        for (int i = 0; i < 10 ; i++) {
            if(i == 5){
                //消息单端过期
                rabbitTemplate.convertAndSend("test_exchange_ttl", "ttl.message01", "message ttl... ", messagePostProcessor);
            }else {
                //不过期的消息
                rabbitTemplate.convertAndSend("test_exchange_ttl", "ttl.message01", "message ttl... ");
            }

        }
    }

    /**
     * 发送测试死信消息
     *   1.过期时间
     *   2.长度限制
     *   3.消息拒收
     */
    @Test
    public void testDlx(){
        //1.测试过期时间，死信消息
        //rabbitTemplate.convertAndSend("test_exchange_dLx","test.dlx.boyan","我是一条消息，会成为死信");
        //2.测试长度限制后，消息死信
        /*for (int i = 0; i < 20  ; i++) {
            rabbitTemplate.convertAndSend("test_exchange_dLx","test.dlx.boyan","我是一条消息，会成为死信");
        }*/
        //3.测试消息拒收
        rabbitTemplate.convertAndSend("test_exchange_dLx","test.dlx.boyan","我是一条消息，会成为死信");
    }

    @Test
    public void testDelay() throws InterruptedException {
        //1.发送订单消息。将来是在订单系统中，下单成功后，发送消息
        rabbitTemplate.convertAndSend("order_exchange","order.message","订单信息：id=1,time=2022年8月18日16:53:29");
        //2.打印倒计时10秒
        for (int i = 10; i > 0; i--) {
            System.out.println(i+"...");
            Thread.sleep(1000);
        }
    }
}
