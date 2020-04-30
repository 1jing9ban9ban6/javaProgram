package com.jing.ioc.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author jing
 * @create 2020-03-05-21:45
 */
public class afterHandler implements BeanPostProcessor {
    /**
     * 再来两个生命周期
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        person person = (person) bean;
        System.out.println("我是加的前置");
        return person;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("我是加的后置");
        person person = (person) bean;
        person=null;
        return person;
    }
}
