package com.jing.stroe.service;

import com.jing.stroe.domain.PageModel;
import com.jing.stroe.domain.Product;

import java.util.List;

public interface ProductService {
    public PageModel findProductsWithCidAndPage(String cid, int curNum) throws Exception;

    public List<Product> getNewProducts() throws Exception; // 查找最新商品

    public List<Product> getHotProducts() throws Exception; // 查找最熱商品

    public Product getProductById(String id) throws Exception; // 根据Id查找商品

    public PageModel findAllProductWithPage(int curNum) throws Exception;

    public void saveProduct(Product product) throws Exception;
}
