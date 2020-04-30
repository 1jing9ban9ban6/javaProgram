package com.jing.mybatis.dao;

import com.jing.mybatis.model.takes;

import java.util.List;

public interface takesDao {
    public List<takes> findTakesAndStudent();
}
