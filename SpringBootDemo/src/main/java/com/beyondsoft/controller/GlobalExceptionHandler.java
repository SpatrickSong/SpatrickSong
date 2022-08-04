package com.beyondsoft.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
//全局异常处理器，使用的是AOP的思想
@ControllerAdvice //异常是作为一个通知
public class GlobalExceptionHandler {
    //括号内表示处理哪些异常，Exception.class表示处理所有
    @ExceptionHandler(Exception.class)
    @ResponseBody
    //Exception exception接收异常类异常对象
    public Map<String,Object> handleExceptiopn(Exception exception){
        //把异常信息封装到Map当中
        Map<String,Object> map = new HashMap<>();
        map.put("errorCode",500);
        map.put("errorMsg",exception.toString());
        return  map;
    }
}
