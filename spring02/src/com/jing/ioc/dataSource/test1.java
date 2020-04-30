package com.jing.ioc.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jing
 * @create 2020-03-05-22:13
 */
public class test1 {
    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("dataSource.xml");
        DruidDataSource dataSource = ac.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
