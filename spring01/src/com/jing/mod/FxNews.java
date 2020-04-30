package com.jing.mod;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author jing
 * @create 2020-04-17-19:50
 */
public class FxNews {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();


    }
//    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry)
//    {
//        AbstractBeanDefinition newsProvider =
//        new RootBeanDefinition(FXNewsProvider.class,true);
//        AbstractBeanDefinition newsListener =
//        new RootBeanDefinition(DowJonesNewsListener.class,true);
//        AbstractBeanDefinition newsPersister =
//        new RootBeanDefinition(DowJonesNewsPersister.class,true);
//        // 将bean定义注册到容器中
//        registry.registerBeanDefinition("djNewsProvider", newsProvider);
//        registry.registerBeanDefinition("djListener", newsListener);
//        registry.registerBeanDefinition("djPersister", newsPersister);
//        // 指定依赖关系
//        // 1. 可以通过构造方法注入方式
//        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
//        argValues.addIndexedArgumentValue(0, newsListener);
//        argValues.addIndexedArgumentValue(1, newsPersister);
//        newsProvider.setConstructorArgumentValues(argValues);
//        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue(new ropertyValue("newsListener",newsListener));
//        propertyValues.addPropertyValue(new PropertyValue("newPersistener",newsPersister));
//        newsProvider.setPropertyValues(propertyValues);
//        // 绑定完成
//        return (BeanFactory)registry;
//    }
}
