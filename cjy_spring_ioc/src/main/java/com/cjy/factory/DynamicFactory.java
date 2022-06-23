package com.cjy.factory;

import com.cjy.dao.UserDao;
import com.cjy.dao.imp.UserDaoImpl;

public class DynamicFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
