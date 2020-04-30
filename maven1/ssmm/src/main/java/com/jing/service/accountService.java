package com.jing.service;

import com.jing.pojo.account;

import java.util.List;

public interface accountService {
    public List<account> findAll();
    public void saveAccount(account account);
}
