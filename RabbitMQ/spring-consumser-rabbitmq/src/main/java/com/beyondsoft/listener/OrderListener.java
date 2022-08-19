package com.beyondsoft.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;
//自动扫描
@Component
public class OrderListener implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        Thread.sleep(1000);
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            //1.接收转换消息
            System.out.println(new String(message.getBody()));
            //2.处理业务逻辑
            System.out.println("处理业务逻辑...");
            System.out.println("根据订单id查询其状态...");
            System.out.println("判断状态是否为支付成功");
            System.out.println("取消订单，回滚库存");
            //3.手动签收
            channel.basicAck(deliveryTag,true);
        } catch (Exception e) {
            //e.printStackTrace();
            //4.拒绝签收
            /**
             * 第三个参数b1:重回队列，如果设置为true,则消息重新回到queue,broker会重新发送该消息给消费端
             */
            channel.basicNack(deliveryTag,true,true);//可以处理多条消息
            //channel.basicReject(deliveryTag,true);//只能处理一个消息
        }
    }
}
