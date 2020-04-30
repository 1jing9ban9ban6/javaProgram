package com.itheima.service;

import com.itheima.domain.Account;
import org.omg.CORBA.PUBLIC_MEMBER;

public interface accountService {
    public Account findAccountById(Integer Id);
    public void transfer(String sourceName, String targetName, Float money);
}
