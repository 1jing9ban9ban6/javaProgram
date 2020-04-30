package com.jing.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jing
 * @create 2020-03-06-22:24
 */
public class test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
        mathI math = ac.getBean("math", mathI.class);
        math.div(1,1);
    }
}
