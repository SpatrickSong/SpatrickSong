package com.beyondsoft.test;

import com.beyondsoft.controller.SpringController;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest (classes= SpringController.class) //测试什么
//@RunWith(SpringJUnit4ClassRunner.class) //谁来测试
@WebAppConfiguration //整合web
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSprintController {
    @Autowired
    private  SpringController springController; //注入SpringController对象

    @Test
    public void  test1(){
//        TestCase.assertEquals(this.springController.yes(),"hehe");
        TestCase.assertEquals(this.springController.yes(),"hehe");
    }
}
