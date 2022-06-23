package com.cjy.demo;

import com.cjy.service.UserService;
import com.cjy.service.imp.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//这里模拟的是web层
public class UserController {
    public static void main(String[] args) {
        /*UserServiceImpl userService = new UserServiceImpl();
        userService.save();*/
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userService = (UserService) app.getBean("UserService");
        UserService userService = app.getBean(UserService.class);
        userService.save();
        /*UserServiceImpl userService = new UserServiceImpl();//创建的对象里面没有dao,因为在UserServiceImpl中根本没给其赋值
        userService.save();//如果用这个方法会报空指针NullPointerException异常,即是往上的userService空*/
    }
}
