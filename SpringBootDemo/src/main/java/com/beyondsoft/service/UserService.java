package com.beyondsoft.service;

import com.beyondsoft.dao.UserDao;
import com.beyondsoft.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //创建service的对象
public class UserService {

    @Autowired //注入 UserDao
    private UserDao userDao;

    @Transactional
    public void serverUser(Users user){
        userDao.addUser(user);
        int i =6/0;
    }
}
