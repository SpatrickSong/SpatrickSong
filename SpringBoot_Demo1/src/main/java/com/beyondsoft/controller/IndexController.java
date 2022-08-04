package com.beyondsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String show(Model model){
        model.addAttribute("name","渊默");
        return "index";
    }
}
