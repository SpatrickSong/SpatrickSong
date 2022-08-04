package com.beyondsoft.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@ConfigurationProperties(prefix="book")
@EnableAutoConfiguration //开启自动配置
@Controller
public class IndaxController {
    //@Value("${book.author}")
    private String author;
    //@Value("${book.name}")
    private String name;
    @ResponseBody //返回字符串
    @RequestMapping("/info")  //访问路径
    public String demo(){

        return author + ":" + name;
    }
    // 入口
   /* public static void main(String[] args) {
//        System.out.println("SSS");
        SpringApplication.run(IndaxController.class,args);
    }*/
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
