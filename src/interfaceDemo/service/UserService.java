package interfaceDemo.service;
/**
 *  业务层的接口
 *  定义了两个方法
 */

public interface UserService {
    public boolean login(String userName, String passWord);
    /**
     * 如果返回 1 两次密码不一致
     * 如果返回 2 用户名已经被注册
     * 如果返回 3 注册成功
     */

    public String zhuCe(String userName, String passWord1, String passWord2);
}
