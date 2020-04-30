package com.jing.pojp;

import java.util.Date;

public class user {
    private String username;
    private String age;
    private Date date;

    public user() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public user(String username, String age, Date date) {
        this.username = username;
        this.age = age;
        this.date = date;
    }

    @Override
    public String toString() {
        return "user{" +
                "username='" + username + '\'' +
                ", age='" + age + '\'' +
                ", date=" + date +
                '}';
    }
}
