package javaSeShop.product.dao;

import javaSeShop.bean.Product;

import java.util.List;

public interface productDao {
    // 增 添加商品
    public boolean addProduct(Product p) throws Exception;
    // 删 删除商品
    public boolean removeProduct(String pId) throws Exception;
    // 修改
    public boolean updateProduct(Product product) throws Exception;
    // 查询
    public Product getProductById(String pId) throws Exception;
    public List<Product> getProductByName(String pName) throws Exception;
    public List<Product> getProductByPrice(float minPrice, float maxPrice) throws Exception;
    public List<Product> getProductByCategoryName(String categoryName) throws Exception;
}
