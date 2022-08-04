package com.beyondsoft.mybatis.test;
import com.beyondsoft.mybatis.mapper.SQLMapper;
import com.beyondsoft.mybatis.pojo.User;
import com.beyondsoft.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.*;
import java.util.List;

public class SQLMapperTest {
    @Test
    public void teatGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper =  sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByLike("a");
        System.out.println(list);
    }

    @Test
    public void teatDeleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper =  sqlSession.getMapper(SQLMapper.class);
        int result = mapper.deleteMore("1,3,4");
        System.out.println(result);
    }

    @Test
    public void teatGetUserByTableName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper =  sqlSession.getMapper(SQLMapper.class);
        List<User> result = mapper.getUserByTableName("t_user");
        System.out.println(result);
    }

    @Test
    public void testJDBC() throws Exception {
        Class.forName("");
        Connection connection = DriverManager.getConnection("","","");
        PreparedStatement ps = connection.prepareStatement("insert ", Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        ResultSet resultSet = ps.getGeneratedKeys();

    }

    @Test
    public void teatInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper =  sqlSession.getMapper(SQLMapper.class);
        User user = new User(null,"段誉","123",24,"男","456789.163.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
