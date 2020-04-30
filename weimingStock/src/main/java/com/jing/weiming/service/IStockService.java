package com.jing.weiming.service;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author jing
 * @create 2020-03-27-12:17
 */
public interface IStockService {
    Map<String, Object> getStockList();// 查询所有商品返回列表
    Map<String, Object> getStockById(String sku_id);// 根据商品ID查询商品的详细信息
    Map<String, Object> insertLimitPolicy (Map<String, Object> policyInfo);// 添加一个秒杀策略
}
