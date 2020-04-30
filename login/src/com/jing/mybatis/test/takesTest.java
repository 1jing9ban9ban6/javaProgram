package com.jing.mybatis.test;

import com.jing.mybatis.model.takes;
import com.jing.mybatis.service.takesService;
import com.jing.mybatis.service.takesServiceImpl;
import org.junit.Test;

import java.util.List;

public class takesTest {
    takesService ts = new takesServiceImpl();
    @Test
    public void findTakesAndStudent(){
        List<takes> re = ts.findTakesAndStudent();
        for (takes takes: re){
            System.out.println(takes);
        }
    }
}
