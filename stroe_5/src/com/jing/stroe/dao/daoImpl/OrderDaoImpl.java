package com.jing.stroe.dao.daoImpl;

import com.jing.stroe.dao.OrderDao;
import com.jing.stroe.domain.Order;
import com.jing.stroe.domain.OrderItem;
import com.jing.stroe.domain.Product;
import com.jing.stroe.domain.User;
import com.jing.stroe.utils.JDBCUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.tools.JavaCompiler;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl implements OrderDao {

    @Override
    public void saveOrder(Connection conn, Order order) throws Exception {
        String sql="INSERT INTO orders VALUES(?,?,?,?,?,?,?,?)";
        Object[] params={order.getOid(),order.getOrdertime(),order.getTotal(),
                order.getState(),order.getAddress(),order.getName(),order.getTelephone(),
                order.getUser().getUid()};
        QueryRunner qr=new QueryRunner();
        qr.update(conn,sql,params);
    }

    @Override
    public void saveOrderItem(Connection conn, OrderItem item) throws Exception {
        String sql="INSERT INTO orderitem VALUES(?,?,?,?,?)";
        Object[] params={item.getItemid(),item.getQuantity(),item.getTotal(),item.getProduct().getPid(),item.getOrder().getOid()};
        QueryRunner qr=new QueryRunner();
        qr.update(conn,sql,params);
    }

    @Override
    public int getTotalRecords(User user) throws Exception{
        String sql = "select count(*) from orders where uid=?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        Long num = (Long)qr.query(sql, new ScalarHandler(), user.getUid());
        return num.intValue();
    }

    @Override
    public List findMyOrdersWithPage(User user, int startIndex, int pageSize) throws Exception{
        String sql = "select * from orders where uid = ? limit ?,?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(Order.class), user.getUid(), startIndex, pageSize);
        for(Order order:orderList){
            // 获取到每笔订单的oid
            String oid = order.getOid();
            sql = "select * from orderItem o, product p where o.pid = p.pid and oid=?";
            qr = new QueryRunner(JDBCUtils.getDataSource());
            List<Map<String, Object>> maps = qr.query(sql, new MapListHandler(), oid);
            // 查询出来是一条多表的复杂语句
            for(Map<String, Object> map:maps){
                // 创建对象
                OrderItem orderItem = new OrderItem();
                Product product = new Product();
                // 时间转换器
                DateConverter dateConverter = new DateConverter();
                dateConverter.setPattern("yyyy-MM-dd");
                ConvertUtils.register(dateConverter, java.util.Date.class);
                // 自动构造对象
                BeanUtils.populate(orderItem, map);
                BeanUtils.populate(product, map);
                // 关联对象
                orderItem.setProduct(product);
                order.getList().add(orderItem);
            }
        }
        return orderList;
    }

    @Override
    public Order findOrderById(String oid) throws Exception{
        // 查询这个订单
        String sql = "select * from orders where oid=?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        Order order = qr.query(sql, new BeanHandler<Order>(Order.class), oid);
        // 获取这个订单下的所有商品
        sql = "select * from orderItem i, product p where i.pid = p.pid and oid=?";
        qr = new QueryRunner(JDBCUtils.getDataSource());
        List<Map<String, Object>> maps = qr.query(sql, new MapListHandler(), oid);
        // 查询出来是一条多表的复杂语句
        for(Map<String, Object> map:maps){
            // 创建对象
            OrderItem orderItem = new OrderItem();
            Product product = new Product();
            // 时间转换器
            DateConverter dateConverter = new DateConverter();
            dateConverter.setPattern("yyyy-MM-dd");
            ConvertUtils.register(dateConverter, java.util.Date.class);
            // 自动构造对象
            BeanUtils.populate(orderItem, map);
            BeanUtils.populate(product, map);
            // 关联对象
            orderItem.setProduct(product);
            order.getList().add(orderItem);
            }
        return order;
        }

    @Override
    public void updateOrder(Order order) throws Exception {
        String sql="UPDATE orders SET ordertime =? , total =? ,state= ?, address=? ,name=? ,telephone =? WHERE oid=?";
        Object[] params={order.getOrdertime(),order.getTotal(),order.getState(),order.getAddress(),order.getName(),order.getTelephone(),order.getOid()};
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        qr.update(sql,params);
    }

    @Override
    public List<Order> findAllOrder() throws Exception {
        String sql = "select * from orders ";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        List<Order> orderList = qr.query(sql, new BeanListHandler<Order>(Order.class));
        return orderList;
    }
}
