package com.jing.service;

import com.jing.dao.accountDao;
import com.jing.pojo.account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class accountServiceImpl implements accountService {

    @Qualifier("accountDao")
    @Autowired
    private accountDao ac;
    @Override
    public List<account> findAll() {
        System.out.println("业务层：查询所有账户");
        return ac.findAll();
    }

    @Override
    public void saveAccount(account account) {
        System.out.println("业务层：保存账户");
        ac.saveAccount(account);
    }
}
