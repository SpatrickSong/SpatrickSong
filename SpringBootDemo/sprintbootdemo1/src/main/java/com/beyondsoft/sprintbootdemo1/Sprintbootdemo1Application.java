package com.beyondsoft.sprintbootdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.beyondsoft.sprintbootdemo1") //扫描service、controller
//@EntityScan("com.beyondsoft.sprintbootdemo1.pojo") // 扫描实体类
//@EnableJpaRepositories("com.beyondsoft.sprintbootdemo1.dao")//扫描dao
@EnableCaching //开启缓存
public class Sprintbootdemo1Application  {

    public static void main(String[] args) {
        SpringApplication.run(Sprintbootdemo1Application.class, args);
    }
}
