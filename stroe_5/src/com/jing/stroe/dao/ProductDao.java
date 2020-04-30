package com.jing.stroe.dao;

import com.jing.stroe.domain.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getNewProducts() throws Exception;
    public List<Product> getHotProducts() throws Exception;
    public Product getProductById(String pid) throws Exception;
    public int findTotalNum(String cid) throws Exception ;
    public int findTotalNum() throws Exception ;
    public List<Product> findProductsWithCidAndPage(String cid, int startIndex, int pageSize) throws Exception ;

    public List<Product> findAllProductWithPage(int startIndex, int pageSize) throws Exception;

    public void saveProduct(Product product) throws Exception;
}
