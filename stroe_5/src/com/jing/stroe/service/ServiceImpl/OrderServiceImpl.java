package com.jing.stroe.service.ServiceImpl;

import com.jing.stroe.dao.OrderDao;
import com.jing.stroe.dao.daoImpl.OrderDaoImpl;
import com.jing.stroe.domain.Order;
import com.jing.stroe.domain.OrderItem;
import com.jing.stroe.domain.PageModel;
import com.jing.stroe.domain.User;
import com.jing.stroe.service.OrderService;
import com.jing.stroe.utils.JDBCUtils;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public void saveOrder(Order order) throws SQLException {
        // 开启事务
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            // 开启事务
            conn.setAutoCommit(false);
            // 保存订单
            OrderDao orderDao = new OrderDaoImpl();
            orderDao.saveOrder(conn, order);
            // 保存所有订单项
            for (OrderItem orderItem:order.getList()){
                orderDao.saveOrderItem(conn, orderItem);
            }
            conn.commit();
        } catch (Exception e){
            conn.rollback();
        }
    }

    @Override
    public PageModel findMyOrdersWithPage(User user, int num) throws Exception {
        OrderDao orderDao = new OrderDaoImpl();
        // 1 创建pagemodel 目的携带分页的信息
        int totalRecords = orderDao.getTotalRecords(user);
        PageModel pageModel = new PageModel(num, totalRecords, 3);
        // 2 关联集合
        List list = orderDao.findMyOrdersWithPage(user, pageModel.getStartIndex(), pageModel.getPageSize());
        pageModel.setList(list);
        // 3 关联url
        pageModel.setUrl("OrderServlet?method=findMyOrdersWithPage");
        return pageModel;
    }
//
//    public static void main(String[] args) throws Exception{
//        OrderService orderService = new OrderServiceImpl();
//        User user = new User();
//        user.setUid("FFC4943E6B2E47DAB6B62BA94CCABA0D");
//        PageModel myOrdersWithPage = orderService.findMyOrdersWithPage(user, 1);
//        List<Order> list = myOrdersWithPage.getList();
//        for (Order order:list){
//            System.out.println(order);
//        }
//    }

    @Override
    public Order findOrderById(String oid) throws Exception{
        OrderDao orderDao = new OrderDaoImpl();
        Order order = orderDao.findOrderById(oid);
        return order;
    }

    @Override
    public void updateOrder(Order orderById) throws Exception{
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.updateOrder(orderById);
    }

    @Override
    public List<Order> findAllOrder() throws Exception {
        OrderDao orderDao = new OrderDaoImpl();
        List<Order> allOrder = orderDao.findAllOrder();
        return allOrder;
    }
}
