package com.jing.weiming.dao;

import java.util.Map;

public interface IOrderDao {
    public Map<String,Object> insertOrder(Map<String, Object> orderInfo);

    public boolean updateOrderStatus(String order_id);
}
