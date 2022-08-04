package com.beyondsoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //如果每个功能返回的都是Restful内容，那么可以使用该注解
public class SpringController {
   private Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("/hehe")
    //返回的是Restful内容，不使用该注解会进行跳转
//    @ResponseBody
    public  String yes(){

        return "hehe";
    }

    @RequestMapping("ok")
//    @ResponseBody
    public  String ok(){
        logger.debug("debug日志");
        logger.info("info日志");
        logger.warn("warn日志");
        logger.error("error日志***");
        return  "hehe";
    }
    //SpringBoot 支持Rest风格
    //@PathVariale:把info/{msg}接收到的参数传递给show(@PathVariale String msg)
    @RequestMapping("/info/{msg}")
    public String show(@PathVariable String msg){

        return  "show:" + msg;
    }
}
