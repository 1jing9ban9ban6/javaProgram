package com.jing.spring.book.controller;

import com.jing.spring.book.dao.bookDao;
import com.jing.spring.book.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jing
 * @create 2020-03-07-16:33
 */
@Controller
public class bookController {
    @Autowired
    bookService bookService;
    public void show(Integer bid, Integer sid, Integer uid){
        bookService.show(bid, sid, uid);
    }
}
