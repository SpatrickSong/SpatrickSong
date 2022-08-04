package com.beyondsoft.mybatis.test;


import com.beyondsoft.mybatis.mapper.SelectMapper;
import com.beyondsoft.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SelectMapperTest {
    /**
     * MyBatis的各种查询功能
     * 1、若查询出的数据只有一条，可以通过实体类对象或者集合接收
     *    a> 可以通过实体类对象接收
     *    b> 可以通过list集合接收
     *    c> 可以通过map集合接收
     *       结果：{password=123456, sex=男, id=6, age=23, email=12345@qq.com, username=admin}
     * 2、若查询出的数据有多条
     * a>可以通过实体类类型的list集合接收
     * b>可以通过map类型的list集合接收
     * c>可以在mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换为map集合作为值，以某个字段的值作为键，放在同一个map集合中
     *   结果：{4={password=123456, sex=?, id=4, age=23, email=12345@qq.com, username=张三}, 6={password=123456, sex=男, id=6, age=23, email=12345@qq.com, username=admin}, 13={password=1234, sex=女, id=13, age=23, email=456.qq.com, username=王语嫣}}
     * 注意：一定不能通过实体类对象接收，此时会抛出异常TooManyResultsException
     * MyBatis中设置了默认的类型别名
     * java.Lang.Integer--int,integer
     * int-->int,integer
     * Map-->map
     * String-->string
     */
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper =  sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(4));;
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper =  sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUser());
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper =  sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }

    @Test
    public void testGetUserByToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper =  sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByToMap(6));
    }

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper =  sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }
}
