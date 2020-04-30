package com.jing.ioc.life;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jing
 * @create 2020-03-05-21:39
 */
public class test1 {
    public static void main(String[] args) {
        /**
         *  bean 的生命周期 有五个 创建对象 依赖注入 调用初始化 使用 销毁
         */
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans-life.xml");
        Object p1 = ac.getBean("p1");
        System.out.println(p1);
        ac.close();
    }
}
