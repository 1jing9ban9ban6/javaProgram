package com.jing.weiming.dao;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author jing
 * @create 2020-03-27-12:18
 */
public interface IStockDao {
    ArrayList<Map<String, Object>> getStockList();
    ArrayList<Map<String, Object>> getStockById(String sku_id);
    Boolean insertLimitPolicy (Map<String, Object> policyInfo);
}
