package com.jing.dao;

import com.jing.pojo.student;

import java.util.List;

public interface studentDao {
    public student getStudentById(String id);
    public List<student> getStudentByName(String name);
    public boolean addStudent(student student);
    public boolean updateStudent(student student);
    public boolean deleteStudent(String id);
}
