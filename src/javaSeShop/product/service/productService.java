package javaSeShop.product.service;

import javaSeShop.bean.Product;

import java.util.List;

public interface productService {
    public List<Product> getAllProduct() throws Exception;
    public List<Product> getProductByCateName(String cateName) throws Exception;
    public List<Product> getProductByPriceRange(float min, float max) throws Exception;
    public Product getProductById(String Id) throws Exception;
    public boolean addProduct(String productInfoString) throws Exception;
    public boolean updateProductName(String pId, String pName) throws Exception;
    public boolean updateProductPrice(String pId, float price) throws Exception;
    public boolean updateProductStock(String pId, int StockNum) throws Exception;
    public boolean updateProductStatus(String pId, String Status) throws Exception;//0上架 1下架 2删除
}
