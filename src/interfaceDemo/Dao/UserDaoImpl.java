package interfaceDemo.Dao;

import interfaceDemo.bin.user;
import interfaceDemo.bin.userDataBase;

public class UserDaoImpl implements UserDao {
    @Override
    public user findUserByName(String name) {
        user user = userDataBase.userMap.get(name);
        return user;
    }
    /**
     *      根据用户名查找该用户是否存在
     */
    @Override
    public boolean checkUserIfChuZai(String name) {
        boolean u = userDataBase.userMap.containsKey(name);
        return u;
    }
    /**
     *  将传来的用户放到数据库中
     */
    @Override
    public void addUser(user user) {
        userDataBase.userMap.put(user.getName(),user);
    }
}
