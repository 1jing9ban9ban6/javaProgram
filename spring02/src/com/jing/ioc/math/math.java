package com.jing.ioc.math;

/**
 * @author jing
 * @create 2020-03-06-21:19
 */
public class math implements mathI {
    @Override
    public int add(int i, int j) {
        System.out.println(i+"+"+j+"="+i+j);
        return i+j;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println(i+"-"+j+"="+(i-j));
        return i-j;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println(i+"*"+j+"="+(i*j));
        return i*j;
    }

    @Override
    public int div(int i, int j) {
        System.out.println(i+"/"+j+"="+(i/j));
        return i/j;
    }
}
