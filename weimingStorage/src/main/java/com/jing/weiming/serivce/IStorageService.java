package com.jing.weiming.serivce;

import java.util.Map;

/**
 * @author jing
 * @create 2020-03-27-22:14
 */
public interface IStorageService {
    Map<String, Object> insertStorage(String sku_id, double in_quanty, double out_quanty);
}
