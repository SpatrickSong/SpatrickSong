package com.beyondsoft.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;
//自动扫描

/**
 * Consumer 限流机制
 * 1.确保ack机制为手动确认 acknowledge="manual"。（手动确认后限流才会生效）
 * 2.在Listener-container配置属性perfetch，能够拉取消息的最大数
 * perfetch=1,表示消费端每次从mq拉取一条消息来消费，直到手动确认消费完毕后，才会继续拉取下一条消息。
 */
@Component
public class QosListener implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        Thread.sleep(1000);
        //1.获取消息
        System.out.println(new String(message.getBody()));
        //2.处理业务逻辑
        //3.签收
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
    }
}
