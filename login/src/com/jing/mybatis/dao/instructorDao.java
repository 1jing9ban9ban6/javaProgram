package com.jing.mybatis.dao;

import com.jing.mybatis.model.instructor;
import com.jing.mybatis.vo.instructorVo;

import java.util.List;

public interface instructorDao {
    public List<instructor> findInstructorByNameAndSalary(instructor instructor);
    public void deleteInstructor(instructorVo vo);
}
