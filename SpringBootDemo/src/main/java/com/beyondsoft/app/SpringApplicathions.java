package com.beyondsoft.app;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

//@EnableAutoConfiguration //在启动时进行自动配置
//@ComponentScan("com.beyondsoft.controller") // 把controller所在的包在启动类中扫描
//默认下扫描当前包及当前包的子包
//scanBasePackages是一个字符串数组可以指定对个值
@SpringBootApplication(scanBasePackages = "com.beyondsoft")
//@EnableAsync //在启动类中开启异步调用
//@EnableScheduling //开启任务调度
public class SpringApplicathions {//implements  WebMvcConfigurer {

    /*@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //创建fastjson消息转换器
        FastJsonHttpMessageConverter convert = new FastJsonHttpMessageConverter();
        //创建fastjson配置对象
        FastJsonConfig config = new FastJsonConfig();
        //对json数据进行格式化
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //把config对象给转换器
        convert.setFastJsonConfig(config);
        //把转换器加入到容器当中
        converters.add(convert);
    }*/
   /* @Bean
    public HttpMessageConverters fastJsonMessageConverter(){
        //创建fastjson消息转换器
        FastJsonHttpMessageConverter convert = new FastJsonHttpMessageConverter();
        //创建fastjson配置对象
        FastJsonConfig config = new FastJsonConfig();
        //对json数据进行格式化
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //把config对象给转换器
        convert.setFastJsonConfig(config);
        HttpMessageConverter<?> con = convert;
        //把返回的对象注入到容器当中
        return  new HttpMessageConverters(con);
    }*/
    public static void main(String[] args) {
        //SpringApplicathions启动方法所在类的类名，args：主函数参数
        SpringApplication.run(SpringApplicathions.class,args);
    }
}
