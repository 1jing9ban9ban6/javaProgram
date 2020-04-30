package com.jing.dao;

import com.jing.pojo.account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository("accountDao")
public interface accountDao {

    @Select("select * from account")
    public List<account> findAll();

    @Insert("insert into account(name, money) values(#{name}, #{money})")
    public void saveAccount(account account);
}
