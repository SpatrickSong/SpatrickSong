package com.beyondsoft.controller;

import com.beyondsoft.pojo.SocketMessage;
import com.beyondsoft.pojo.SocketResponse;
import javafx.beans.property.SimpleListProperty;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketController {

    @RequestMapping("index")
    public String toPage(){
        return "webSocket";
    }
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //当浏览器向服务器端发送STOMP请求时，通过@MessageMapping?注解来映射/getServerTime.地址
    @MessageMapping(value = "getServerTime")

    //当服务端有消息时，会对订阅了@SendTo中的路径的客户端发送消息
    @SendTo(value = "topic/getResponse")
    public SocketResponse serverTime(SocketMessage message){
        return new SocketResponse(message.getMessage() + sf.format(new Date()));
    }
}
