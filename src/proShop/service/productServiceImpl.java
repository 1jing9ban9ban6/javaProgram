package proShop.service;


import proShop.Dao.productDaoImpl;
import proShop.bin.product;

import java.util.ArrayList;

public class productServiceImpl implements productService{
    proShop.Dao.productDao productDao = new productDaoImpl();
    @Override
    public String addProduct(String id, String name, float price, int kcNumber) {
//        1、用户可以通过输入商品信息来向库中添加商品
        product product = productDao.checkProductById(id);
        if (product==null){
            productDao.addProduct(id, name, price, kcNumber);
            return "1"; // 添加成功
        }
        return "2"; // 添加失败 已经有相同的id了
    }

    @Override
    public ArrayList<product> checkAllProduct() {
        ArrayList<product> products = new ArrayList<product>();
        products = productDao.checkAllProduct();
        return products;
    }

    @Override
    public product checkProductById(String id) {
        product product = productDao.checkProductById(id);
        return product;
    }

    @Override
    public ArrayList<product> checkProductByName(String name) {
        ArrayList<product> product = productDao.checkProductByName(name);
        return product;
    }

    @Override
    public ArrayList<product> checkProductByPrice(String price_s) {
        String[] split = price_s.split("->");
        float a = Float.parseFloat(split[0]);
        float b = Float.parseFloat(split[1]);
        ArrayList<product> product = productDao.checkProductByPrice(a, b);
        return product;
    }

    @Override
    public String DeleteProductById(String id) {
        product product = productDao.checkProductById(id);
        if (product==null){
            return "2" ;// 没有该id，删除失败
        }
        productDao.DeleteProductById(id);
        return "1";// 删除成功
    }

    @Override
    public String updateNameById(String id, String name) {
        product product = productDao.checkProductById(id);
        if (product==null){
            return "2"; // 更新失败，查无此人
        }
        productDao.updateNameById(product, name);
        return "1"; //更新成功
    }

    @Override
    public String updatePriceById(String id, float price) {
        product product = productDao.checkProductById(id);
        if (product==null){
            return "2"; // 更新失败，查无此人
        }
        productDao.updatePriceById(product, price);
        return "1"; // 更新成功
    }

    @Override
    public String updateKcNumById(String id, int kcNum) {
        product product = productDao.checkProductById(id);
        if (product==null){
            return "2"; // 更新失败，查无此人
        }
        productDao.updateKcNumById(product, kcNum);
        return "1"; // 更新成功
    }
}
