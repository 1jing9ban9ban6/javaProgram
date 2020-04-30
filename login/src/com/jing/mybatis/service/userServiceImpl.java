package com.jing.mybatis.service;

import com.jing.mybatis.dao.userDao;
import com.jing.mybatis.model.user;
import com.jing.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class userServiceImpl implements userService {
    @Override
    public user findUserByNameAndPassword(user u) {
        SqlSessionFactory factory = MybatisUtil.getFactory();
        SqlSession session = factory.openSession();
        userDao mapper = session.getMapper(userDao.class);
        mapper.findUserByNameAndPassword(u);
        return u;
    }
}
