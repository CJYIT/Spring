package com.cjy.dao.iml;

import com.cjy.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//实现UserDao接口，本来在spring下bean换成注解的形式
//<!--    配置dao-->
//<bean id="userDao" class="com.cjy.dao.imp.UserDaoImpl"></bean>
// 换成注解的形式
//@Component("userDao")
@Repository("userDao")//dao主要用于数据存储，使用这个注解可读性比@Component强
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save running......");
    }
}
