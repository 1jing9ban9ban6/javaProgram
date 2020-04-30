package com.jing.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author jing
 * @create 2020-03-07-12:34
 */
@Aspect
@Order(value = 1)
@Component
public class youLog {
    @Before(value = "execution(* com.jing.spring.aop.*.*(..))")
    public void test1(){
        System.out.println("我是1");
    }
}
