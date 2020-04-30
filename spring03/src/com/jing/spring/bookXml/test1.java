package com.jing.spring.bookXml;

import com.jing.spring.bookXml.controller.bookController;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jing
 * @create 2020-03-07-17:39
 */
public class test1 {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("book-xml1.xml");
        bookController bookController = ac.getBean("bookController", bookController.class);
        bookController.show(1, 1, 1001);
    }
}
