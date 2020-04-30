package com.jing.ioc.scope;

/**
 * @author jing
 * @create 2020-03-05-21:21
 */
public class student {
    private Integer sid;
    private String studentName;

    @Override
    public String toString() {
        return "student{" +
                "sid=" + sid +
                ", studentName='" + studentName + '\'' +
                '}';
    }

    public student(Integer sid, String studentName) {
        this.sid = sid;
        this.studentName = studentName;
    }

    public student() {
        System.out.println("我是构造方法");
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
