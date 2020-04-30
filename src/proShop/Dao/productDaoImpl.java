package proShop.Dao;

import proShop.bin.product;
import proShop.bin.shopDataBase;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class productDaoImpl implements productDao{
    @Override
    public void addProduct(String id, String name, float price, int kcNumber) {
        product product = new product(id, name, price, kcNumber);
        shopDataBase.shopDB.put(product.getId(), product);
    }

    @Override
    public ArrayList<product> checkAllProduct() {
        ArrayList<product> products = new ArrayList<product>();
        Set<Map.Entry<String, product>> entrySet = shopDataBase.shopDB.entrySet();
        for (Map.Entry entry:entrySet){
            product value = (product)entry.getValue();
            products.add(value);
        }
        return products;
    }

    @Override
    public product checkProductById(String id) {
        product product = shopDataBase.shopDB.get(id);
        return product;
    }

    @Override
    public ArrayList<product> checkProductByName(String name) {
        // 生成一个商品列表，按名字查 商品有可能重复，所以返回一个列表
        ArrayList<product> products = new ArrayList<product>();
        // 把每个hashMap 中的实体索引出来
        Set<Map.Entry<String, product>> entries = shopDataBase.shopDB.entrySet();
        // 找每个对象
        for (Map.Entry entry: entries){
            // 将product对象取出来
            product value = (product) entry.getValue();
            // 检查名字是否存在
            if (value.getName().equals(name)){
                //是我们要找的对象，添加进去
                products.add(value);
            }
        }
        return products;
    }

    @Override
    public ArrayList<product> checkProductByPrice(float a, float b) {
        // 生成一个商品列表，按名字查 商品有可能重复，所以返回一个列表
        ArrayList<product> products = new ArrayList<product>();
        // 把每个hashMap 中的实体索引出来
        Set<Map.Entry<String, product>> entries = shopDataBase.shopDB.entrySet();
        // 找每个对象
        for (Map.Entry entry: entries){
            // 将product对象取出来
            product value = (product) entry.getValue();
            // 检查名字是否存在
            if (value.getPrice()>=a && value.getPrice()<=b){
                //是我们要找的对象，添加进去
                products.add(value);
            }
        }
        return products;
    }

    @Override
    public void DeleteProductById(String id) {
        shopDataBase.shopDB.remove(id);
    }

    @Override
    public void updateNameById(product product, String name) {
        product.setName(name);
        shopDataBase.shopDB.replace(product.getId(),product);
    }


    @Override
    public void updatePriceById(product product, float price) {
        product.setPrice(price);
        shopDataBase.shopDB.replace(product.getId(),product);
    }

    @Override
    public void updateKcNumById(product product, int kcNumber) {
        product.setKcNumber(kcNumber);
        shopDataBase.shopDB.replace(product.getId(),product);
    }
}
