package com.jing.mybatis.model;

import java.util.List;

public class student {
    private String ID;
    private String name;
    private String dept_name;
    private float tot_cred;
    private List<takes> takes;

    public student() {
    }

    public student(String ID, String name, String dept_name, float tot_cred, List<takes> takes) {
        this.ID = ID;
        this.name = name;
        this.dept_name = dept_name;
        this.tot_cred = tot_cred;
        this.takes = takes;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public float getTot_cred() {
        return tot_cred;
    }

    public void setTot_cred(float tot_cred) {
        this.tot_cred = tot_cred;
    }

    @Override
    public String toString() {
        return "student{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", dept_name='" + dept_name + '\'' +
                ", tot_cred=" + tot_cred +
                ", takes=" + takes +
                '}';
    }

    public List<takes> getTakes() {
        return takes;
    }

    public void setTakes(List<takes> takes) {
        this.takes = takes;
    }
}
