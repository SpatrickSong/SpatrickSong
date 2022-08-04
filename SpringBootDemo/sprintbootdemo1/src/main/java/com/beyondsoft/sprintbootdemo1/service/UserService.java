package com.beyondsoft.sprintbootdemo1.service;

import com.beyondsoft.sprintbootdemo1.pojo.User;

import java.util.Optional;

public interface UserService {
    void addUser(User user);
    Optional<User> findUser(Integer id);
    void delUser(Integer id);
    public String findRedis();
}
