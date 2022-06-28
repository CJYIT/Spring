package com.cjy.dao.impl;

import com.cjy.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;
//实现
public class AccountDaoImpl implements AccountDao {
//引入jdk模板
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
//转出钱的方法
    public void out(String outMan, double money) {
        jdbcTemplate.update("update account set money=money-? where name=?",money,outMan);
    }
//转入钱的方法
    public void in(String inMan, double money) {
        jdbcTemplate.update("update account set money=money+? where name=?",money,inMan);
    }
}
