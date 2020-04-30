package com.jing.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jing.service.accountService;
public class testSpring {
    @Test
    public void run(){
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        accountService as = ac.getBean("accountService", accountService.class);
        as.findAll();
//        as.saveAccount();
    }
}
