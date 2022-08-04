package com.beyondsoft.sprintbootdemo1.controller;

import com.beyondsoft.sprintbootdemo1.pojo.User;
import com.beyondsoft.sprintbootdemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    @ResponseBody
    public String saveUser(){
        User user = new User();
        user.setName("dy");
        user.setPassword("123456");
        user.setEmail("456123@qq.com");
        user.setBirthday(new Date());
        userService.addUser(user);
        return "success";
    }

    @RequestMapping("/find/{id}")
    @ResponseBody
    public Optional<User> findUser(@PathVariable Integer id){
        return userService.findUser(id);
    }

    @RequestMapping("/del/{id}")
    @ResponseBody
    public String delUser(@PathVariable Integer id){
        userService.delUser(id);
        return "ok";
    }

    @RequestMapping("/redis")
    @ResponseBody
    public String findRedis(){
        return userService.findRedis();
    }
}
