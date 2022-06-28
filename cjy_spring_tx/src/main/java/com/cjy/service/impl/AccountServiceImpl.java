package com.cjy.service.impl;

import com.cjy.dao.AccountDao;
import com.cjy.service.AccountService;
//业务层，这里调用dao层的方法,业务层又将被web调用,这里使用controller模拟web层
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
//转账的方法   参数:转出人,转入人,转多少钱
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
        int i = 1/0;
        accountDao.in(inMan,money);
    }
}
