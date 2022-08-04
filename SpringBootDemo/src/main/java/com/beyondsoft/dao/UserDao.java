package com.beyondsoft.dao;

import com.beyondsoft.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository //创建对象
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void addUser(Users user){
        jdbcTemplate.update("insert into users(name,password,email,birthday) values (?,?,?,?)",
                new Object[]{user.getName(),user.getPassword(),user.getEmail(),user.getBirthday()});
    }
}
