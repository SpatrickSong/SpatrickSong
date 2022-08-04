package com.beyondsoft.controller;

import com.beyondsoft.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @Autowired
    private Order order;

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
