package com.beyondsoft.mybatis.test;

import com.beyondsoft.mybatis.mapper.DeptMapper;
import com.beyondsoft.mybatis.mapper.EmpMapper;
import com.beyondsoft.mybatis.pojo.Dept;
import com.beyondsoft.mybatis.pojo.Emp;
import com.beyondsoft.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ResultMapTest {
    /**
     * 解决字段名和属性名不一致的情况:
     * a>为字段起别名，保持和属性名的一致
     * b>设置全局配置将下划线自动映射成驼峰
     * <setting name="mapUnderscoreToCamelCase" value="true"/>
     * c>通过resultMap设置自定义的映射关系
     *  <resultMap id="empResultMap" type="Emp">
     *    <id property="eid" column="eid"></id>
     *    <result property="empName" column="emp_name"></result>
     *    <result property="age" column="age"></result>
     *    <result property="sex" column="sex"></result>
     *    <result property="email" column="email"></result>
     *  </resultMap>
     *
     * 处理多对一的映射关系
     * a>级联属性赋值
     * b>使用association
     * c>分步查询(常用)
     *
     * 处理一对多的映射关系
     * a>使用collection
     * b>分步查询
     */
    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.genAllEmp();
        list.forEach(emp -> System.out.println(emp));
    }

    @Test
        public void testGetEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(2);
        System.out.println(emp);
    }

    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(1);
        System.out.println(emp.getEmpName());
        System.out.println("++++++++++++++++++++++");
        System.out.println(emp.getDept());
    }

    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(2);
        System.out.println(dept);
    }

    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(2);
        System.out.println(dept);
    }
}
