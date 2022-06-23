package com.cjy.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.beans.PropertyVetoException;

//此注解标志该类是Spring的核心配置类
@Configuration
/*<!--配置组件扫描   base-package基础包，会帮你扫描配置的路径下的所有注解-->
<context:component-scan base-package="com.cjy"/>*/
@ComponentScan("com.cjy")
//<!--    <import resource=""/>-->
@Import({DataSourceConfiguration.class})//将分的配置文件加载到这里的主配置文件中,如果导入多个分配置文件的话用都好隔开

public class SpringCofiguration {

}
