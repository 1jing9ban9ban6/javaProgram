package com.jing.mapper;

import com.jing.pojo.student;

import java.util.List;

public interface StudentMapper {
    public student getStudentById(String id);
    public List<student> getStudentByName(String name);
    public boolean addStudent(student student);
    public boolean updateStudent(student student);
    public boolean deleteStudent(String id);
}
