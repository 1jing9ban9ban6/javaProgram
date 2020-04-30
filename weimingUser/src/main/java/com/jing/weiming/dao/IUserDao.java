package com.jing.weiming.dao;

import java.util.List;
import java.util.Map;

/**
 * @author jing
 * @create 2020-03-28-11:55
 */
public interface IUserDao {
    List<Map<String, Object>> getUser(String username, String password);
    int insertUser(String username, String password);
}
