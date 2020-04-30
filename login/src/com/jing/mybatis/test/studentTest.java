package com.jing.mybatis.test;

import com.jing.mybatis.model.student;
import com.jing.mybatis.service.studentService;
import com.jing.mybatis.service.studentServiceImpl;
import org.junit.Test;

import java.util.List;

public class studentTest {
    studentService ts = new studentServiceImpl();
    @Test
    public void findTakesAndStudent(){
        List<student> list = ts.findStudentTakes();
        for (student s: list){
            System.out.println(s);
        }
    }
}
