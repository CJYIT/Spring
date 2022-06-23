package com.cjy.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.util.ResourceBundle;

public class DataSourceTest {
    @Test
    public void testC3P0ByProperties() throws Exception {
//加载类路径下的jdbc.properties读取配置文件
        ResourceBundle rb =ResourceBundle.getBundle("jdbc");//写基本名称jdbc就行
        String driver = rb.getString("jdbc.driver");//key是配置文件里面的，往下一一对应
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");
        //创建数据源
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //设置数据库连接参数
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        //获得连接对象
//        Connection connection = dataSource.getConnection();
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    public void testDruid() throws Exception {
//创建数据源        ②创建Druid连接池
        DruidDataSource dataSource = new DruidDataSource();
//设置数据库连接参数
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
//获得连接对象
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
//    手动创建c3p0数据源        ②创建C3P0连接池
    public void test1() throws Exception {
        //创建数据源
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //设置数据库连接参数
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        //获得连接对象
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //关闭数据源
        connection.close();
    }
}
