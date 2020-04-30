package com.jing.spring.bookXml.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author jing
 * @create 2020-03-07-16:34
 */
@Repository
public class bookDaoImpl implements bookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer selectBookById(Integer bid) {
        String sql = "select price from book where bid=?";
        Integer integer = jdbcTemplate.queryForObject(sql, new Object[]{bid}, Integer.class);
        return integer;
    }

    @Override
    public void updateBook(Integer sid) {
        String sql2 = "UPDATE stock set st = st-1 where sid = ?";
        jdbcTemplate.update(sql2, sid);
        String sql1 = "select st from stock where sid=?";
        Integer st = jdbcTemplate.queryForObject(sql1, new Object[]{sid}, Integer.class);
        if (st<0){
            throw new RuntimeException();
        }
    }

    @Override
    public void updateMoney(Integer uid, Integer price) {
        String sql2 = "UPDATE money set balance = balance-? where uid = ?";
        jdbcTemplate.update(sql2, price, uid);
        String sql1 = "select balance from money where uid=?";
        Integer pr = jdbcTemplate.queryForObject(sql1, new Object[]{uid}, Integer.class);
        if (pr<0){
            throw new RuntimeException();
        }
    }
}
