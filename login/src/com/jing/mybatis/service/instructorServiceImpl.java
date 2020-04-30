package com.jing.mybatis.service;

import com.jing.mybatis.dao.instructorDao;
import com.jing.mybatis.model.instructor;
import com.jing.mybatis.util.MybatisUtil;
import com.jing.mybatis.vo.instructorVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

public class instructorServiceImpl implements instructorService {
    @Override
    public List<instructor> findInstructorByNameAndSalary(instructor instructor) {
        SqlSessionFactory factory = MybatisUtil.getFactory();
        SqlSession session = factory.openSession();
        instructorDao mapper = session.getMapper(instructorDao.class);
        List<instructor> re =
                mapper.findInstructorByNameAndSalary(instructor);
        return re;
    }

    @Override
    public void deleteInstructor(instructorVo vo) {
        SqlSessionFactory factory = MybatisUtil.getFactory();
        SqlSession session = factory.openSession();
        instructorDao mapper = session.getMapper(instructorDao.class);
        ArrayList<String> list = new ArrayList<>();
        mapper.deleteInstructor(vo);
        session.commit();
        session.close();
    }
}
