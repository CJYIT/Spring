package com.cjy.test;

import com.cjy.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//指定spring内核进行测试
@ContextConfiguration("classpath:applicationContext.xml")//指定配置文件
public class JdbcTemplateCRUDTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void testUpdata(){
        int row = jdbcTemplate.update("update account set money =? where name =?", 999, "lisi");
        System.out.println(row);
    }
    @Test
    public void testDelete(){
        jdbcTemplate.update("delete from account where name =?",  "lisi");
    }
    @Test
//    聚合查询,查询数据总数,查询的是一个简单类型使用requiredtype:Long.class
    public void testQueryCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);
    }
    @Test
//    查询一个对象,查询的是一个实体需要用new BeanPropertyRowMapper映射
    public void testQueryOne(){
        Account account = jdbcTemplate.queryForObject("select * from account where name=?",
                new BeanPropertyRowMapper<Account>(Account.class), "tom");
        System.out.println(account);
    }
    @Test
//    查询全部
    public void testQueryAll(){
        //sql语句,rowmaper接口,我们就给这个接口对应的实现new BeanPropertyRowMapper,Account是要封装实体的泛型,字节码Account.class
        List<Account> accountList = jdbcTemplate.query("select * from account",
                new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }
}
