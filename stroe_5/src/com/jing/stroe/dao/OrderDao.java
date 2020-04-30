package com.jing.stroe.dao;

import com.jing.stroe.domain.Order;
import com.jing.stroe.domain.OrderItem;
import com.jing.stroe.domain.User;

import java.sql.Connection;
import java.util.List;

public interface OrderDao {
    public void saveOrder(Connection conn, Order order) throws Exception;

    public void saveOrderItem(Connection conn, OrderItem orderItem) throws Exception;

    public int getTotalRecords(User user) throws Exception;

    public List findMyOrdersWithPage(User user, int startIndex, int pageSize) throws Exception;

    public Order findOrderById(String oid) throws Exception;

    public void updateOrder(Order orderById) throws Exception;

    public List<Order> findAllOrder() throws Exception;
}
