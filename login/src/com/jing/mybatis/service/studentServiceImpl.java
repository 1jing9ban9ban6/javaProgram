package com.jing.mybatis.service;

import com.jing.mybatis.dao.StudentDao;
import com.jing.mybatis.model.student;
import com.jing.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class studentServiceImpl implements studentService {
    @Override
    public List<student> findStudentTakes() {
        SqlSessionFactory factory = MybatisUtil.getFactory();
        SqlSession session = factory.openSession();
        StudentDao mapper = session.getMapper(StudentDao.class);
        List<student> list = mapper.findStudentTakes();
        return list;
    }
}
