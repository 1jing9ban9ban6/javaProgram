package com.jing.spring.xmlaop;

import org.springframework.stereotype.Component;

/**
 * @author jing
 * @create 2020-03-06-21:19
 */
@Component
public class math implements mathI {
    @Override
    public int add(int i, int j) {
        int i1 = i + j;
        return i1;
    }

    @Override
    public int sub(int i, int j) {
        int i1 = i - j;
        return i1;
    }

    @Override
    public int mul(int i, int j) {
        int i1 = i * j;
        return i1;
    }

    @Override
    public int div(int i, int j) {
        int i1 = i / j;
        return i1;
    }
}
