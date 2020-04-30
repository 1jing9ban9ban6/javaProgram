package cn.controller;

import cn.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jing
 * @create 2020-03-26-18:16
 */
@Controller
public class UserController {
    @RequestMapping(value = "/UserRegisterStep", method = RequestMethod.GET)
    public String userRegisterStep() {
        return "register";
    }

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public String getAll(User user) {
        System.out.println(user);
        return "index";
    }
}
