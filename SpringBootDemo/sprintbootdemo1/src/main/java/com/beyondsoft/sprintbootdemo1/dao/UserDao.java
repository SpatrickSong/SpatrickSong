package com.beyondsoft.sprintbootdemo1.dao;

import com.beyondsoft.sprintbootdemo1.pojo.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Integer> {
}
