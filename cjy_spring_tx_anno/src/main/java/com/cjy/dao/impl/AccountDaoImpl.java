package com.cjy.dao.impl;

import com.cjy.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//实现
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
//引入jdk模板
    @Autowired
    private JdbcTemplate jdbcTemplate;
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {//使用了自动注入,这个方法可以不要
//        this.jdbcTemplate = jdbcTemplate;
//    }
//转出钱的方法
    public void out(String outMan, double money) {
        jdbcTemplate.update("update account set money=money-? where name=?",money,outMan);
    }
//转入钱的方法
    public void in(String inMan, double money) {
        jdbcTemplate.update("update account set money=money+? where name=?",money,inMan);
    }
}
