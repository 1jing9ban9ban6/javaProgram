package interfaceDemo.service;

import interfaceDemo.Dao.UserDao;
import interfaceDemo.Dao.UserDaoImpl;
import interfaceDemo.bin.user;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public boolean login(String userName, String passWord) {
        // 调DAO层的功能去查寻该用户是否存在，传一个用户名，返回一个用户对象
        user userByName = userDao.findUserByName(userName);
        if (userByName == null){
            return false;
        }
        if(userByName.getPassword().equals(passWord)){
            return true;
        }
        return false;
    }

    @Override
    public String zhuCe(String userName, String passWord1, String passWord2) {
        // 调Dao层的功能去检查该用户名是否已经存在
        boolean b = userDao.checkUserIfChuZai(userName);
        if (b){
            return "2";
        }
        // 直接判断两次密码是否一致
        boolean c = passWord1.equals(passWord2);
        if (!c){
            return "1";
        }
        // 将用户所写入的数据写到数据库中
        user u = new user();
        u.set(userName, passWord1);
        userDao.addUser(u);
        return "3";
    }
}
