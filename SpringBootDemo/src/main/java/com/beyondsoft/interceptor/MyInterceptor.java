package com.beyondsoft.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Configuration //声明这是一个配置
public class MyInterceptor extends WebMvcConfigurerAdapter {
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor inter = new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                                     Object handler) throws Exception {
                System.out.println("自定义拦截器......");
                return true;
            }
            @Override

            public void postHandle(HttpServletRequest request, HttpServletResponse response,
                                   Object handler, ModelAndView modelAndView) throws Exception {
                HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                        Object handler, Exception ex) throws Exception {
                HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
            }
        };
        //注册拦截器，/**表示拦截所有
        registry.addInterceptor(inter).addPathPatterns("/**");
    }*/
}
