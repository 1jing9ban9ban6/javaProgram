package com.jing.weiming.service;

import java.util.List;
import java.util.Map;

/**
 * @author jing
 * @create 2020-03-28-11:56
 */
public interface IUserService {
    Map<String, Object> getUser(String username, String password);
    Map<String, Object> insertUser(String username, String password);

}
