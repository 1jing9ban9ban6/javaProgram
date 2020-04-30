package com.jing.ioc.auto;

/**
 * @author jing
 * @create 2020-03-06-11:45
 */
public class car extends carExtends{
    private Integer cid;
    private String cname;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "car{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
