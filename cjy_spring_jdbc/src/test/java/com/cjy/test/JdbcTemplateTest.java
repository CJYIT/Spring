package com.cjy.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JdbcTemplateTest {
    @Test
//    测试spring产生JdbcTemplateTest对象
    public void test2() throws PropertyVetoException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        int row = jdbcTemplate.update("insert into account values(?,?)", "laowang", 5000);
        System.out.println(row);
    }
    @Test
//    测试JdbcTemplateTest开发步骤
    public void test1() throws PropertyVetoException {
//        创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("root");
//        实际就如下三步
//         1创建模板对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        2设置数据源对象,知道数据库在哪里，这里的数据源对象dataSource需要有
        jdbcTemplate.setDataSource(dataSource);
//        3执行操作                   这里account有个误报,我禁用了它的检查
        int row = jdbcTemplate.update("insert into account values(?,?)", "lisi", 5999);//这里的account报错不用管
        System.out.println(row);
    }
}
