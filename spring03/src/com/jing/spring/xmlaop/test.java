package com.jing.spring.xmlaop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jing
 * @create 2020-03-07-13:17
 */
public class test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("aop-xml.xml");
        mathI math = ac.getBean("math", mathI.class);
        math.add(1,2);
    }
}
