package com.jing.ioc.auto;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jing
 * @create 2020-03-06-11:53
 */
public class test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans-auto.xml");
        emp emp = ac.getBean("emp1", emp.class);
        System.out.println(emp);
    }
}
