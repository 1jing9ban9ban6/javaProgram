package com.jing.mapper;

import com.jing.pojo.course;

import java.util.List;

public interface CourseMapper {
    // 查询所有课程
    public List<course> getAllCourse();
    public course getCourseByCourseId(String id);
}
