package javaSeShop.product.dao;

import javaSeShop.bean.Product;

import java.util.List;

public interface pproductDao {

    public List<Product> getAllProduct() throws Exception;
    public List<Product> getProductByCateName(String cateName) throws Exception;
    public List<Product> getProductByPriceRange(float min, float max) throws Exception;
    public Product getProductById(String Id) throws Exception;
    public boolean addProduct(Product product) throws Exception;
    public boolean updateProduct(Product product) throws Exception;

}
