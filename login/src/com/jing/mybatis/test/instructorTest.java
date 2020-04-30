package com.jing.mybatis.test;

import com.jing.mybatis.model.instructor;
import com.jing.mybatis.service.instructorService;
import com.jing.mybatis.service.instructorServiceImpl;
import com.jing.mybatis.vo.instructorVo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class instructorTest {
    instructorService is = new instructorServiceImpl();
    @Test
    public void findInstructorByNameAndSalary(){
        instructor it = new instructor();
        it.setInstructorName("Wu");
        it.setSalary(90000);
        List<instructor> re = is.findInstructorByNameAndSalary(it);
        System.out.println(re);
    }
    @Test
    public void deleteInstructorTest(){
        instructorVo instructorVo = new instructorVo();
        ArrayList<String> list = new ArrayList<String>();
        list.add("13131");
        list.add("13132");
        list.add("13133");
        instructorVo.setIds(list);
        is.deleteInstructor(instructorVo);
    }
}
