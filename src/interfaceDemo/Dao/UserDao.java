package interfaceDemo.Dao;

import interfaceDemo.bin.user;

public interface UserDao {
    // 根据用户名返回用户对象
    public user findUserByName(String name);
    public boolean checkUserIfChuZai(String name);
    public void addUser(user user);
}
