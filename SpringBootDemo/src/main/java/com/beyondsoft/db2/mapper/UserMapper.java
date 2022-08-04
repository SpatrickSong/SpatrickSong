package com.beyondsoft.db2.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("db2SqlSessionFactory")
public interface UserMapper {
    @Insert("insert into user(username,age) values(#{username},#{age})")
    void addUser(@Param("username")String username, @Param("age")int age);
}
