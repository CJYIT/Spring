package com.cjy.service.impl;

import com.cjy.dao.AccountDao;
import com.cjy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//业务层，这里调用dao层的方法,业务层又将被web调用,这里使用controller模拟web层
@Service("accountService")//要在配置文件中进行组件扫描,才能扫到@Service
public class AccountServiceImpl implements AccountService {
@Autowired
    private AccountDao accountDao;
//    public void setAccountDao(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }
//转账的方法   参数:转出人,转入人,转多少钱
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
        int i = 1/0;
        accountDao.in(inMan,money);
    }
    //@Transactional(isolation = Isolation.DEFAULT)//方法2,在类上注解,类下所有未重新注解的都用类的,如果方法里重新注解则用方法的
    public void xxx(){}
}
