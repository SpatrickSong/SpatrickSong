package com.beyondsoft.mybatis.mapper;

import com.beyondsoft.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /**
     * 通过分步查询员工以及员工所对应的部门信息
     * 分步查询第二步：通过did查询员工对应的部门信息
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    /**
     * 获取部门以及部门中所有员工的信息
     */
    Dept getDeptAndEmp(@Param("did") Integer did);

    /**
     * 通过分步查询查询部门以及部门中所有员工的信息
     * 分步查询的第一步：查询部门信息
     */
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);
}

