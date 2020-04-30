package com.jing.mod;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author jing
 * @create 2020-03-05-13:34
 */
public class person {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * @author jing
     * @create 2020-03-05-13:36
     */
    public static class testPerson {
        @Test
        public void test1() throws Exception{
            // 初始化容器 由spring容器来管理  将你想交给spring 管理的的写在xml里 然后给这个容器
            ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext
                    ("applicationContext.xml");
    //        person person = (com.jing.mod.person) ac.getBean("person"); // 写xml的id person
            person person = ac.getBean(person.class);
            ac.close();
            System.out.println(person);
        }
    }
}
