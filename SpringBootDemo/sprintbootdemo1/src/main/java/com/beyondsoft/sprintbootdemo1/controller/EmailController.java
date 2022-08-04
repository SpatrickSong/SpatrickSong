package com.beyondsoft.sprintbootdemo1.controller;

import com.beyondsoft.sprintbootdemo1.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/simple")
    @ResponseBody
    public String sendSimpleEmail(){
        emailService.sendSimpleEmail("1098738522@qq.com","会议记录","本周工作情况");
        return "success";
    }

    @RequestMapping("/attach")
    @ResponseBody
    public String sendAttachmentMail(){
        File file = new File("F:\\VIP\\hehe.txt");
        emailService.sendAttachmentMail("1098738522@qq.com","你好","世界",file);
        return "success";
    }

    @RequestMapping("/template")
    @ResponseBody
    public String sendTemplateMail(){
        emailService.sendTemplateMail("1098738522@qq.com","我的人生","info.html");
        return "success";
    }
}
