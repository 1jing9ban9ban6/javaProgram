package com.jing.ui;

import com.jing.dao.IAccountDao;
import com.jing.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 * spring的核心容器根据id获取对象
 * ApplicationContext 三个常用实现类
 * ClassPathXmlApplicationContext 可以加载类路径下的配置文件
 * FileSystemXmlApplicationContext 可以加载磁盘任意路径配置文件
 * AnnotationConfigApplicationContext 读取注解创建容器
 *
 * ApplicationContext （适用单例）它在构建核心容器读取配置文件后就会创建所有配置过的对象
 * BeanFactory （适用多粒）是延时构造， 需要了才会创建
 */
public class Client {

    public static void main(String[] args) {
        // 获取核心容器
        ApplicationContext ac = new
                ClassPathXmlApplicationContext("bean.xml");
//        FileSystemXmlApplicationContext("G:\\英雄时刻\\57.spring\\spring\\spring_day01\\代码\\spring_day01\\day01_eesy_03spring\\src\\main\\resources")
        // 根据核心获取对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao", IAccountDao.class);
        System.out.println(as);
        System.out.println(adao);
    }
}
