package com.jing.stroe.service;

import com.jing.stroe.domain.Order;
import com.jing.stroe.domain.PageModel;
import com.jing.stroe.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {
    public void saveOrder(Order order) throws SQLException;

    public PageModel findMyOrdersWithPage(User user, int num) throws Exception;

    public Order findOrderById(String oid) throws Exception;

    public void updateOrder(Order orderById) throws Exception;

    public List<Order> findAllOrder() throws Exception;

}
