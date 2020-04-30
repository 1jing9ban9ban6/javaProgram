package com.jing.ioc.scope;

import com.sun.media.sound.SoftTuning;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jing
 * @create 2020-03-05-21:23
 */
public class test {
    @Test
    public void test1(){
        /**
         *  若是单例容器初始化就开始 创建
         *  若不是多利 在使用的时候创建
         */
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans-scope.xml");
        student s1 = ac.getBean("s1", student.class);
        student s2 = ac.getBean("s1", student.class);
        System.out.println(s1.equals(s2));
    }
}
