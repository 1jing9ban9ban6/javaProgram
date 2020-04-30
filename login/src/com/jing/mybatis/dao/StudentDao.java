package com.jing.mybatis.dao;

import com.jing.mybatis.model.student;

import java.util.List;

public interface StudentDao {
//    public student getStudentById(String id);
//    public List<student> getStudentByName(String name);
//    public boolean addStudent(student student);
//    public boolean updateStudent(student student);
//    public boolean deleteStudent(String id);
    public List<student> findStudentTakes();
}
