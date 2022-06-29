package com.cjy.domain;

import java.util.List;

public class VO {

    private List<User> userList;//userList集合里面放的是User对象

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "VO{" +
                "userList=" + userList +
                '}';
    }
}
