package com.jing.ioc.life;

import org.springframework.stereotype.Repository;

/**
 * @author jing
 * @create 2020-03-05-21:33
 */
public class person {
    private Integer id;
    private String name;
    private String sex;

    public person() {
        System.out.println("1创建对象");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("2依赖注入");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public void init(){
        System.out.println("3初始化");
    }
    public void destroy(){
        System.out.println("5销毁");
    }

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
