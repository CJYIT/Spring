package com.cjy.test;

import com.cjy.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void test1(){
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
//        UserDao userDao2 = (UserDao) app.getBean("UserDao");
        System.out.println(userDao1);
//        System.out.println(userDao2);
//        app.close();
    }
}
