package com.jing.weiming.dao;

import java.util.Map;

/**
 * @author jing
 * @create 2020-03-27-22:14
 */
public interface IStorageDao {
    Map<String, Object> insertStorage(String sku_id, double in_quanty, double out_quanty);
}
