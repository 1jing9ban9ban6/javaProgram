package javaSeShop.product.service;

import javaSeShop.bean.Product;
import javaSeShop.product.dao.pproductDao;

import java.util.List;
public class productServiceImpl implements productService {
    pproductDao productDao = null;
    @Override
    public List<Product> getAllProduct() throws Exception  {
        List<Product> pList = productDao.getAllProduct();
        return pList;
    }

    @Override
    public List<Product> getProductByCateName(String cateName) throws Exception  {
        List<Product> pList = productDao.getProductByCateName(cateName);
        return pList;
    }

    @Override
    public List<Product> getProductByPriceRange(float min, float max) throws Exception  {
        List<Product> pList = productDao.getProductByPriceRange(min, max);
        return pList;
    }

    @Override
    public Product getProductById(String id) throws Exception  {
        Product p = productDao.getProductById(id);
        return p;
    }
    // p01,香蕉,10.8,1000,水果,0
    @Override
    public boolean addProduct(String productInfoString) throws Exception  {
        String[] split = productInfoString.split(",");
        Product product = new Product(split[0], split[1], Float.parseFloat(split[2]),
                Integer.parseInt(split[3]), split[4], split[5]);
        boolean b = productDao.addProduct(product);
        return b;
    }

    @Override
    public boolean updateProductName(String pId, String pName) throws Exception {
        Product p = productDao.getProductById(pId);
        p.setpName(pName);
        boolean b = productDao.updateProduct(p);
        return b;
    }

    @Override
    public boolean updateProductPrice(String pId, float price) throws Exception  {
        Product p = productDao.getProductById(pId);
        p.setPrice(price);
        boolean b = productDao.updateProduct(p);
        return b;
    }

    @Override
    public boolean updateProductStock(String pId, int StockNum) throws Exception {
        Product p = productDao.getProductById(pId);
        p.setStockNum(StockNum);
        boolean b = productDao.updateProduct(p);
        return b;
    }

    @Override
    public boolean updateProductStatus(String pId, String Status) throws Exception {
        Product p = productDao.getProductById(pId);
        p.setStatus(Status);
        boolean b = productDao.updateProduct(p);
        return b;
    }
}
