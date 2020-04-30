package com.jing.service.impl;

import com.jing.dao.IAccountDao;
import com.jing.dao.impl.AccountDaoImpl;
import com.jing.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();


    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
