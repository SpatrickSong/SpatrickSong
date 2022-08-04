package com.beyondsoft.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("db1SqlSessionFactory")
public interface UsersMapper {
    @Insert("insert into users(name,password,email) values(#{name},#{password},#{email})")
    void addUser(@Param("name") String name, @Param("password")String password,@Param("email")String email);
}
