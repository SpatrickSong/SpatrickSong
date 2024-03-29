package com.beyondsoft.springbootdemo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching //开启缓存
public class Springbootdemo3Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootdemo3Application.class, args);
    }

}
