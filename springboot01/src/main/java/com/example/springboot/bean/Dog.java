package com.example.springboot.bean;

/**
 * @author jing
 * @create 2020-04-24-11:53
 */
public class Dog {
    private String dName;
    private String dAge;

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdAge() {
        return dAge;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dName='" + dName + '\'' +
                ", dAge='" + dAge + '\'' +
                '}';
    }

    public void setdAge(String dAge) {
        this.dAge = dAge;
    }
}
