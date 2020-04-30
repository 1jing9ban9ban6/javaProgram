package javaSeShop.bean;

import java.io.Serializable;
/**
 *
 * 描述用户数据的实体类
 */
public class User implements Serializable {
    // 一个对象定义出来 一般就是一些私有的属性，构造方法，toString get和set。
    private String account;
    private String password;
    private String name;
    private int age;
    private int vipLevel;
    private String phone;
    private String addr;


    public User() {

    }

    public User(String account, String password, String name,
                int age, int vipLevel, String phone, String addr) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.age = age;
        this.vipLevel = vipLevel;
        this.phone = phone;
        this.addr = addr;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", vipLevel='" + vipLevel + '\'' +
                ", phone='" + phone + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
