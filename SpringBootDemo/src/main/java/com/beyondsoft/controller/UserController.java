package com.beyondsoft.controller;

import com.beyondsoft.pojo.User;
//import com.beyondsoft.service.UserService;
import com.beyondsoft.pojo.Users;
import com.beyondsoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/saveUser")
    @ResponseBody
    public String save(){
        Users user = new Users();
        user.setName("龙源");
        user.setPassword("123456");
        user.setEmail("123456@163.com");
        user.setBirthday(new Date());
        userService.serverUser(user);
        return "success";
    }
}
