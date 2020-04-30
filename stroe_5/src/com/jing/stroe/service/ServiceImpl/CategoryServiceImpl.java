package com.jing.stroe.service.ServiceImpl;

import com.jing.stroe.dao.CategoryDao;
import com.jing.stroe.dao.daoImpl.CategoryDaoImpl;
import com.jing.stroe.domain.Category;
import com.jing.stroe.service.CategoryService;
import com.jing.stroe.utils.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> findAllCats() throws Exception {
        CategoryDao categoryDao = new CategoryDaoImpl();
        List<Category> categories = categoryDao.findAllCats();
        return categories;
    }

    @Override
    public void addCategory(Category category) throws Exception{
        CategoryDao categoryDao = new CategoryDaoImpl();
        categoryDao.addCategory(category);
        Jedis jedis = JedisUtils.getJedis();
        jedis.del("allCats");
        JedisUtils.closeJedis(jedis);
    }

    @Override
    public Category findCategoryByName(String oldName) throws Exception{
        CategoryDao categoryDao = new CategoryDaoImpl();
        Category category = categoryDao.findCategoryByName(oldName);
        return category;
    }

    @Override
    public Category findCategoryById(String cid) throws Exception {
        CategoryDao categoryDao = new CategoryDaoImpl();
        Category category = categoryDao.findCategoryById(cid);
        return category;
    }

    @Override
    public void updateCategory(Category category) throws Exception {
        CategoryDao categoryDao = new CategoryDaoImpl();
        categoryDao.updateCategory(category);
        Jedis jedis = JedisUtils.getJedis();
        jedis.del("allCats");
        JedisUtils.closeJedis(jedis);
    }
}
