package com.beyondsoft.controller;

import com.beyondsoft.activemq.Producer;
import com.beyondsoft.mq.MySender;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Destination;

@Controller
public class TextController {

    @Autowired
    private Producer producer;

    @Autowired
    private MySender mySender;

    @RequestMapping("/activemq")
    @ResponseBody
    public String tests(){
        //点对点消息
        Destination des = new ActiveMQQueue("myqueues");
        for (int i = 1; i <= 3 ; i++) {
            producer.sendMessage(des,"hello");
        }
        return "ok";
    }

    @RequestMapping("/send")
    @ResponseBody
    public String test(){
        mySender.send();
        return "ok";
    }
}
