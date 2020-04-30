package com.jing.stroe.dao.daoImpl;

import com.jing.stroe.dao.ProductDao;
import com.jing.stroe.domain.Product;
import com.jing.stroe.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    /**
     * 查找最新的商品
     * @return
     */
    @Override
    public List<Product> getNewProducts() throws Exception{
        String sql="SELECT * FROM product WHERE pflag=0 ORDER BY pdate DESC LIMIT 0 , 9";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanListHandler<Product>(Product.class));
    }

    /**
     * 查找最熱最新的商品
     * @return
     */
    @Override
    public List<Product> getHotProducts() throws Exception{
        String sql="SELECT * FROM product WHERE pflag=0 AND is_hot= 1 ORDER BY pdate DESC LIMIT 0 , 9";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanListHandler<Product>(Product.class));
    }

    @Override
    public Product getProductById(String pid) throws Exception {
        String sql="SELECT * FROM product WHERE pid=?";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanHandler<Product>(Product.class), pid);
    }
    @Override
    public int findTotalNum(String cid) throws Exception {
        String sql="select count(*) from product where cid=?";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        Long num=(Long)qr.query(sql, new ScalarHandler(),cid);
        return num.intValue();
    }

    @Override
    public List<Product> findProductsWithCidAndPage(String cid, int startIndex, int pageSize) throws Exception {
        String sql="SELECT * FROM product WHERE cid=? LIMIT ?,?";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanListHandler<Product>(Product.class),cid,startIndex,pageSize);
    }

    @Override
    public int findTotalNum() throws Exception {
        String sql="select count(*) from product";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        Long num=(Long)qr.query(sql, new ScalarHandler());
        return num.intValue();
    }

    @Override
    public List<Product> findAllProductWithPage(int startIndex, int pageSize) throws Exception {
        String sql="SELECT * FROM product LIMIT ?,?";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanListHandler<Product>(Product.class),startIndex,pageSize);
    }

    @Override
    public void saveProduct(Product product) throws Exception {
        String sql="INSERT INTO product VALUES( ?,?,?,?,?,?,?,?,?,? )";
        Object[] params={product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCid()};
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        qr.update(sql,params);
    }
}
