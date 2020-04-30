package com.jing.controller;

import com.jing.pojo.account;
import com.jing.service.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class accountController {
    @Autowired
    private accountService accountService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层：查询所有账户");
//      调用service
        List<account> all = accountService.findAll();
        model.addAttribute("list",all);
        return "list";
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(account account){
        System.out.println("表现层：保存");
//      调用service
        accountService.saveAccount(account);
        return "list";
    }
}
