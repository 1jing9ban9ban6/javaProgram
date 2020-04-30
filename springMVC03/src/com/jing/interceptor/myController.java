package com.jing.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jing
 * @create 2020-03-10-17:03
 */
@Controller
public class myController {
    @RequestMapping(value = "/testInterceptor", method = RequestMethod.GET)
    public String test1(){

        return "success";
    }
}
