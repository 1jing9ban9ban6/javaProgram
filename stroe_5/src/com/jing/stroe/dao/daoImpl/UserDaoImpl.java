package com.jing.stroe.dao.daoImpl;

import com.jing.stroe.dao.UserDao;
import com.jing.stroe.domain.User;
import com.jing.stroe.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserDaoImpl implements UserDao {
    /**
     * 新建用户
     * @param user
     * @throws Exception
     */
    @Override
    public void userRegist(User user) throws Exception{
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
        Object[] params={user.getUid(),user.getUsername(),user.getPassword(),
                user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),
                user.getSex(),user.getState(),user.getCode()};
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        qr.update(sql,params);
    }

    /**
     * 根据一个邮箱验证码查找用户
     * @param code
     * @return
     * @throws Exception
     */
    @Override
    public User findUserByCode(String code) throws Exception{
        String sql = "select * from user where code = ?";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanHandler<User>(User.class), code);
    }

    /**
     * 对一个用户进行更新
     * @param user
     * @throws Exception
     */
    @Override
    public void userUpdate(User user) throws Exception{
        String sql="UPDATE USER SET username= ? ,PASSWORD=? ,NAME =? ," +
                "email =? ,telephone =? , birthday =?  ,sex =? ,state= ? , " +
                "CODE = ? WHERE uid=?";
        Object[] params={user.getUsername(),user.getPassword(),user.getName(),
                user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),
                user.getState(),user.getCode(),user.getUid()};
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        qr.update(sql,params);
    }

    @Override
    public User findUserByNameAndPassword(User user) throws Exception {
        String sql = "select * from user where username = ? and password = ?";
        Object[] params={user.getUsername(),user.getPassword()};
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanHandler<User>(User.class), params);
    }
}
