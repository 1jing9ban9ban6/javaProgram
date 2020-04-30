package com.jing.stroe.service;

import com.jing.stroe.domain.Category;

import java.util.List;

public interface CategoryService {
    // 查找所有商品类别
    public List<Category> findAllCats() throws Exception;

    public void addCategory(Category category) throws Exception;

    public Category findCategoryByName(String oldName) throws Exception;

    public Category findCategoryById(String cid)throws Exception;

    public void updateCategory(Category category)throws Exception;
}
