package com.beyondsoft.db.service;

import com.beyondsoft.db.mapper.UsersMapper;
import com.beyondsoft.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void saveUser(Users user) {
        usersMapper.addUser(user.getName(),user.getPassword(),user.getEmail());
    }
}
