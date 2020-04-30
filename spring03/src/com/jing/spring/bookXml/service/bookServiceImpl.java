package com.jing.spring.bookXml.service;

import com.jing.spring.bookXml.dao.bookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jing
 * @create 2020-03-07-16:34
 */
@Service
public class bookServiceImpl implements bookService {
    @Autowired
    private bookDao bookDao;

    public void show(Integer bid, Integer sid, Integer uid){
        Integer price = bookDao.selectBookById(bid);
        bookDao.updateBook(sid);
        bookDao.updateMoney(uid, price);
    }
}
