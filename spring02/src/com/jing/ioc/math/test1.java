package com.jing.ioc.math;

/**
 * @author jing
 * @create 2020-03-06-22:24
 */
public class test1 {
    public static void main(String[] args) {
        math math = new math();
        mathI proxy = (mathI) proxyUtil.getProxy(math);
//        System.out.println(proxy.getClass());
        proxy.add(1,2);
    }
}
