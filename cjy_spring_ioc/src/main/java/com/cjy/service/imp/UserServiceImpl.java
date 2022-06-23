package com.cjy.service.imp;

import com.cjy.dao.UserDao;
import com.cjy.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }
/*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    public void save() {
       /* ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");//加载配置文件
        UserDao userDao = (UserDao) app.getBean("UserDao");*/  //容器使用了set方法注入后，需要在容器中配置告诉容器
        userDao.save();
    }
}
