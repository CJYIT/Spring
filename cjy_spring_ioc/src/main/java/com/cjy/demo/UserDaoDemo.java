package com.cjy.demo;

import com.cjy.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoDemo {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");//加载配置文件
        UserDao userDao = (UserDao) app.getBean("UserDao");
        userDao.save();
    }
}
