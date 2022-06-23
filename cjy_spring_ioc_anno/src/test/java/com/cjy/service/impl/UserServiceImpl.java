package com.cjy.service.impl;

import com.cjy.dao.UserDao;
import com.cjy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//<!--    配置userService,注入set方法userDao-->
//<bean id="userService" class="com.cjy.service.impl.UserServiceImpl">
//@Component("userService")
@Service("userService")
public class UserServiceImpl implements UserService {
    /*@Value("普通字符串的注入")//这种应用场景没什么用*/
    @Value("${jdbc.driver}")//Spring容器中找对应的key，将key的值给driver
    private String driver;

//    <property name="userDao" ref="userDao"></property>  Qualifier("userDao")意思是注入给bean的id("userDao")
//    @Autowired//按照数据类型从Spring容器中进行匹配的
//    @Qualifier("userDao")//这里可以去掉，//是按照id值从容器中进行匹配的 但是主要此处@Qualifier结合@Autowired一起使用
    @Resource(name="userDao") //@Resource相当于@Qualifier+@Autowired
//    dao与service都在容器当中，可以在容器内部进行通过set方法直接注入
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {//使用注解注入的方式，这个set方法可以不写
        this.userDao = userDao;
    }

    public void save() {
        System.out.println(driver);
        userDao.save();//注入成功能直接调用dao的save()方法
    }
@PostConstruct
    public void init(){
        System.out.println("Service对象的初始化方法");
    }
@PreDestroy
    public void destroy(){
        System.out.println("Service对象的销毁方法");//容器没有关闭容器就执行完毕，如果想要执行完毕再关闭容器，需在设置一下手动关闭
    }
}
