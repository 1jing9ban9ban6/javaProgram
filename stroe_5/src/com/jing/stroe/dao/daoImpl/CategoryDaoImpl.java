package com.jing.stroe.dao.daoImpl;

import com.jing.stroe.dao.CategoryDao;
import com.jing.stroe.domain.Category;
import com.jing.stroe.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> findAllCats() throws Exception{
        String sql="select * from category where label='1' ";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanListHandler<Category>(Category.class));
    }

    @Override
    public void addCategory(Category category) throws Exception{
        String sql="insert into category values ( ? ,?)";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        qr.update(sql,category.getCid(), category.getCname());
    }

    @Override
    public Category findCategoryByName(String oldName) throws Exception{
        String sql="select * from category where cname=?";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanHandler<Category>(Category.class), oldName);
    }

    @Override
    public Category findCategoryById(String cid) throws Exception{
        String sql="select * from category where cid=?";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        return qr.query(sql, new BeanHandler<Category>(Category.class), cid);
    }

    @Override
    public void updateCategory(Category category) throws Exception {
        String sql="update category set cname=?,label = ? where cid=?";
        QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
        qr.update(sql,category.getCname(), category.getLabel(), category.getCid());
    }
}
