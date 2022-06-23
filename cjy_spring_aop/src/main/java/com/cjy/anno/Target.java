package com.cjy.anno;

import org.springframework.stereotype.Component;

@Component("target")
//目标，这个目标需要实现接口TargetInterface
public class Target implements TargetInterface {
    public void save() {
        System.out.println("save running.....");
//        int i = 1 / 0;//设置一个异常
    }
}
