package com.jing.spring.jdbcTem;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jing
 * @create 2020-03-07-13:45
 */
public class test1 {
    ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("jdbc.xml");
    JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
    @Test
    public void test1(){
        jdbcTemplate.update("insert into user values (10,'小王','2015-10-11','女','北京')");
    }
    @Test
    public void test2(){
        String sql = "insert into user values (?, ?, ?, ?, ?)";
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{13,"小王","2015-10-11","女","北京"});
        jdbcTemplate.batchUpdate(sql, list);
    }
}
