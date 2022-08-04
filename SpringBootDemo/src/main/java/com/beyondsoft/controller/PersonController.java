package com.beyondsoft.controller;

import com.beyondsoft.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class PersonController {
    @RequestMapping("/person")
    @ResponseBody
    public Object show(){
        Person prs =new Person();
        prs.setId(666);
        prs.setName("重阳");
        prs.setDate(new Date());
        return  prs;
    }
}
