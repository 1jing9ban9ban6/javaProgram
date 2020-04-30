package com.jing.di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jing
 * @create 2020-03-05-14:47
 */
public class testStu {
    @Test
    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans-di.xml");
//        student s3 = ac.getBean("s3", student.class);
//        System.out.println(s3);
//        teacher t2 = ac.getBean("t2", teacher.class);
//        System.out.println(t2);
//        teacher t3 = ac.getBean("t3", teacher.class);
//        System.out.println(t3);
//        teacher t4 = ac.getBean("t4", teacher.class);
//        System.out.println(t4);
//        teacher t5 = ac.getBean("t5", teacher.class);
//        System.out.println(t5);
//        teacher t6 = ac.getBean("t6", teacher.class);
//        System.out.println(t6);
        teacher t7 = ac.getBean("t7", teacher.class);
        System.out.println(t7);
    }
}
