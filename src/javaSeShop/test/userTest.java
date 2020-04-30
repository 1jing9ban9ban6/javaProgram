package javaSeShop.test;

import javaSeShop.bean.User;
import javaSeShop.user.dao.userDaoIMpl;
import org.junit.Test;

import java.util.ArrayList;

public class userTest {
    @Test
    public void addUserTest() throws Exception {
        userDaoIMpl userDaoIMpl = new userDaoIMpl();
        User u1 = new User("xx8", "asasas",
                "ff3", 42, 2, "15527656797", "baoding");
        userDaoIMpl.addUser(u1);
        User jing123 = userDaoIMpl.getUserByAccount(u1.getAccount());
        System.out.println(jing123);
    }

    @Test
    public void removeTest() throws Exception {
        userDaoIMpl userDaoIMpl = new userDaoIMpl();
        userDaoIMpl.removeUser("jing123");
        User jing123 = userDaoIMpl.getUserByAccount("jing123");
        System.out.println(jing123);
    }

    @Test
    public void addUser() throws Exception {
        userDaoIMpl userDaoIMpl = new userDaoIMpl();
        User u1 = new User("xx1", "asasas",
                "ff1", 21, 1, "15527656797", "baoding");
        User u2 = new User("xx2", "asasas",
                "ff2", 34, 2, "15527656797", "wuhan");
        User u3 = new User("xx3", "asasas",
                "ff3", 12, 3, "15527656797", "chongqing");
        User u4 = new User("xx4", "asasas",
                "ff4", 23, 4, "15527656797", "beijing");
        User u5 = new User("xx5", "asasas",
                "ff5", 42, 1, "15527656797", "shanghai");
        User u6 = new User("xx6", "asasas",
                "ff6", 6, 2, "15527656797", "hebei");
        User u7 = new User("xx7", "asasas",
                "ff7", 18, 3, "15527656797", "handan");
        userDaoIMpl.addUser(u1);
        userDaoIMpl.addUser(u2);
        userDaoIMpl.addUser(u3);
        userDaoIMpl.addUser(u4);
        userDaoIMpl.addUser(u5);
        userDaoIMpl.addUser(u6);
        userDaoIMpl.addUser(u7);
    }

    @Test
    public void getUserByNameTest() throws Exception {
        userDaoIMpl userDaoIMpl = new userDaoIMpl();
        ArrayList<User> ff3list = userDaoIMpl.getUserByName("ff3");
        System.out.println(ff3list);
    }
}
