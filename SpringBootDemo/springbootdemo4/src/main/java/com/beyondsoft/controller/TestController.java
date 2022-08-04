package com.beyondsoft.controller;

import com.beyondsoft.pojo.User;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*@Controller
public class TestController {
    //Springboot在启动时自动配置了ElasticsearchTemplate
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @RequestMapping("/search")
    @ResponseBody
    public String findDoc(){

        //构造搜索条件
        QueryBuilder builder = QueryBuilders.existsQuery("first name");
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(builder).build();
        List<User> users = elasticsearchTemplate.queryForList(searchQuery,User.class);
        for (User user:users ) {
            System.out.println(user);
        }
        return "success";
    }
}*/
