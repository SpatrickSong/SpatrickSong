package com.beyondsoft.db2.service;

import com.beyondsoft.db2.mapper.UserMapper;
import com.beyondsoft.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveUser(User user) {
        userMapper.addUser(user.getUsername(),user.getAge());
    }
}
