package com.beyondsoft.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.beyondsoft")
public class SpringAPP {
    public static void main(String[] args) {
        SpringApplication.run(SpringAPP.class,args);
    }
}
