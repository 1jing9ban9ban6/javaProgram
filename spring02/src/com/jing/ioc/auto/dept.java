package com.jing.ioc.auto;

/**
 * @author jing
 * @create 2020-03-06-11:45
 */
public class dept implements deptI{
    private Integer did;
    private String dname;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "dept{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }
}
