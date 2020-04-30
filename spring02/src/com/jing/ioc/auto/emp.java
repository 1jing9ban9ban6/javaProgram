package com.jing.ioc.auto;

/**
 * @author jing
 * @create 2020-03-06-11:45
 */
public class emp {
    private Integer eid;
    private String ename;
    private deptI dept;
    private carExtends car;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public deptI getDept() {
        return dept;
    }

    public void setDept(deptI dept) {
        this.dept = dept;
    }

    public carExtends getCar() {
        return car;
    }

    public void setCar(carExtends car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", dept=" + dept +
                ", car=" + car +
                '}';
    }
}
