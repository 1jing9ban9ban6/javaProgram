package com.jing.spring.xmlaop;

import org.springframework.stereotype.Component;

/**
 * @author jing
 * @create 2020-03-07-13:11
 */
@Component
public class myLogger {
    public void before(){
        System.out.println("我是xml的前置");
    }
}
