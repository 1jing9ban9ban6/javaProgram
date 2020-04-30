package com.jing.ioc.math;

/**
 * @author jing
 * @create 2020-03-06-22:46
 */
public class myLog {
    public static void before(String methodName, Object... args){
        System.out.println("woshibefore");
    }
    public static void after(String methodName, Object... args){
        System.out.println("woshiafter");
    }
}
