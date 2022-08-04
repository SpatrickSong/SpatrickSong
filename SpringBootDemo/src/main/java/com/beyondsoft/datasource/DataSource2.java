package com.beyondsoft.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration //注册到spring容器当中
@MapperScan(basePackages = "com.beyondsoft.db2.mapper",sqlSessionFactoryRef = "db2SqlSessionFactory")


public class DataSource2 {

    /**
     * 配置db2数据库
     * 生成数据源对象
     * @return
     */
    @Bean(name = "db2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }
    /**
     * 创建SqlSessionFactory(依赖于数据源)
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "db2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("db2DataSource")DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    /**
     * 配置事务管理(依赖于数据源)
     * @param dataSource
     * @return
     */
    @Bean(name = "db2TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("db2DataSource")DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     *封装数据库
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = "db2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}