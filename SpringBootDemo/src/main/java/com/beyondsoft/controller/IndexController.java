package com.beyondsoft.controller;

import com.beyondsoft.db.mapper.UsersMapper;
import com.beyondsoft.db.service.UsersService;
import com.beyondsoft.db2.service.UserService;
import com.beyondsoft.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private UsersService usersService;
    @RequestMapping("/thymeleafpage")
    public  String tests(Model model){
        model.addAttribute("word","致良知");
        return "tests";
    }
    @RequestMapping("/page")
    public String show(Model model){
        model.addAttribute("name","知行合一");
        return "show";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(){
        Users users = new Users();
        users.setName("乔峰");
        users.setPassword("6666666");
        users.setEmail("12345@qq.com");
        usersService.saveUser(users);
        return "ok";
    }
}
