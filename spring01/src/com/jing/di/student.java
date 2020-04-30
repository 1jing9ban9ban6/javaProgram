package com.jing.di;

/**
 * @author jing
 * @create 2020-03-05-14:44
 */
public class student {
    private  Integer id;
    private String name;
    private Integer age;
    private String sex;
    private teacher teacher;


    public student() {

    }

    public com.jing.di.teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(com.jing.di.teacher teacher) {
        this.teacher = teacher;
    }

    public student(String s, Integer integer, String s2, String s23) {
        System.out.println("hah");
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
