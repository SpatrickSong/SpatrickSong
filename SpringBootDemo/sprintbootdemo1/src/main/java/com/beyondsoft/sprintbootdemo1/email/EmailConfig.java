package com.beyondsoft.sprintbootdemo1.email;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class EmailConfig {

    @Value("${spring.mail.username}") //获取全局配置文件内容
    private String emailFrom;
}
