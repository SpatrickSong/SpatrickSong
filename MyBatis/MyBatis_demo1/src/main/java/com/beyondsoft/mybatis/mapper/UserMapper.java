package com.beyondsoft.mybatis.mapper;

import com.beyondsoft.mybatis.pojo.User;

import java.util.List;

/**
 * 1、因为mybatis有面向接口编程的功能，每当我们去调用接口中的方法，
 * 它就会自动去匹配一个sql语句并执行
 * 2、MyBatis面向接口编程两个一致：
 *    1)、映射文件的命名空间(namespace)要和mapper接口的全类名保特一致
 *    2)、映射文件中SQL语句的id要和mapper接口中的方法名一致
 * 根据接口找到映射文件，根据方法名找到对应的SQL语句
 * 表---实体类---mapper接口---映射文件
 */
public interface UserMapper {
    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();

    /**
     * 根据id查询用户信息
     */
    User getUserById();

    /**
     * 查询所有用户信息
     */
    List<User> getAllUser();
}
