package com.jing.factory;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jing
 * @create 2020-03-05-21:01
 */
public class test {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean-factory.xml");
        // 工厂模式创建bean 字节码是 真实的bean
        car factory = ac.getBean("factory", car.class);
        System.out.println(factory);
    }
}
