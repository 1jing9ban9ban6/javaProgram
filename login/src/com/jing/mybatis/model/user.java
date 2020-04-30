package com.jing.mybatis.model;

public class user {
    private int userId;
    private String password;
    private String userName;
    private int age;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public user(int userId, String password, String userName, int age) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.age = age;
    }

    public user() {
    }

    @Override
    public String toString() {
        return "user{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
