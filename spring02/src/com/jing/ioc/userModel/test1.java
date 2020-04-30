package com.jing.ioc.userModel;

import com.jing.ioc.life.person;
import com.jing.ioc.userModel.controller.userController;
import com.jing.ioc.userModel.dao.userDao;
import com.jing.ioc.userModel.dao.userDaoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jing.ioc.userModel.*;

/**
 * @author jing
 * @create 2020-03-06-13:02
 */
public class test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("user.xml");
//        userController userController = ac.getBean("userController", userController.class);
//        System.out.println(userController);
//        userDao daoImpl = ac.getBean("userDaoImpl", userDaoImpl.class);
        userController controller = ac.getBean("userController", userController.class);
        controller.addUser();
    }
}
