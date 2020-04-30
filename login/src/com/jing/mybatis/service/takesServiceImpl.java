package com.jing.mybatis.service;

import com.jing.mybatis.dao.takesDao;
import com.jing.mybatis.model.takes;
import com.jing.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class takesServiceImpl implements takesService {
    @Override
    public List<takes> findTakesAndStudent() {
        SqlSessionFactory factory = MybatisUtil.getFactory();
        SqlSession session = factory.openSession();
        takesDao mapper = session.getMapper(takesDao.class);
        List<takes> re = mapper.findTakesAndStudent();
        return re;
    }
}
