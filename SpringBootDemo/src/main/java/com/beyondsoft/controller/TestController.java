package com.beyondsoft.controller;

//import org.apache.logging.log4j.Logger;
import com.beyondsoft.service.AsyncService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.Charset;
import java.util.concurrent.Future;

@Controller
public class TestController {
    //调用service需要注入service
    @Autowired
    private AsyncService asyncService;
//    private static Logger
    /*private Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("show")
    @ResponseBody
    public String show(){
        logger.debug("debug日志");
        logger.info("info日志");
        logger.warn("warn日志");
        logger.error("error日志");
        return "show";
    }*/

    // SpringBoot默认配置了消息转换器
    // 定义消息转换器
   /* @Bean
    public StringHttpMessageConverter stringHttpMessageConverter(){
        StringHttpMessageConverter convert = new StringHttpMessageConverter(Charset.forName("ISO8859-1"));
        return  convert;
    }*/
    @RequestMapping("/tt")
    @ResponseBody
    public String tests(){

        return  "hello:你好";
   }

   @RequestMapping("/except")
   @ResponseBody
   public String exception(){
        int a = 5/0; //创造一个异常
        return "except";
   }

   @RequestMapping("/async")
   @ResponseBody
   public String asyncTest() throws Exception{
        Long start = System.currentTimeMillis();
        Future<String> task1 = asyncService.doTask1();
        Future<String> task2 = asyncService.doTask2();
        Future<String> task3 = asyncService.doTask3();
        while (true){
            //判断所有线程是否已经执行完成
            if (task1.isDone() && task2.isDone() && task3.isDone()){
                break;
            }
            Thread.sleep(1000);
        }
       Long end = System.currentTimeMillis();
        return "全部执行完成，总耗时："+(end-start)+"毫秒";
   }
}
