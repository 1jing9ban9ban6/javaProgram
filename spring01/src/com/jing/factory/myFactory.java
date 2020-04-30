package com.jing.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author jing
 * @create 2020-03-05-20:57
 */
public class myFactory implements FactoryBean<car> {
    @Override
    public car getObject() throws Exception {
        car c = new car();
        c.setBrand("奥迪");
        c.setPrice(12000.0);
        return c;
    }

    @Override
    public Class<?> getObjectType() {
        return car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
