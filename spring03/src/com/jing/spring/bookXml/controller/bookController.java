package com.jing.spring.bookXml.controller;

import com.jing.spring.bookXml.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
