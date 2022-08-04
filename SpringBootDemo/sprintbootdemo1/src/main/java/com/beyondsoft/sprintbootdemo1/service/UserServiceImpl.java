package com.beyondsoft.sprintbootdemo1.service;

import com.beyondsoft.sprintbootdemo1.dao.UserDao;
import com.beyondsoft.sprintbootdemo1.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private JedisCluster jedisCluster;

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    @Cacheable(value = "myname")
    public Optional<User> findUser(Integer id) {
        System.out.println("从数据库中查询.....");
        return userDao.findById(id);
    }

    @Override
    public void delUser(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public String findRedis() {
        jedisCluster.set("hehe","kele"); //向集群中存入键值对
        return jedisCluster.get("hehe"); //返回存入的值
    }

}
