package com.jing.spring.book.dao;

/**
 * @author jing
 * @create 2020-03-07-16:34
 */
public interface bookDao {
    Integer selectBookById(Integer bid);
    void updateBook(Integer sid);
    void updateMoney(Integer uid, Integer price);
}
