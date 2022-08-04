package com.beyondsoft.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

//创建任务的对象
@Component
public class MyJob {
/*    //实现每隔一秒打印一次
    @Scheduled(fixedRate = 1000)
    public  void run(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }*/
}
