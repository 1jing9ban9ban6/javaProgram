package javaSeShop.product.dao;

import javaSeShop.bean.Product;
import javaSeShop.constants.DataBaseConstants;
import javaSeShop.fileOperateUtils.readWriteUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class productDaoImpl implements productDao {
    readWriteUtil<Product> readWriteUtil = new readWriteUtil();
    @Override
    public boolean addProduct(Product p) throws Exception{
        HashMap<String, Product> productHashMap = null;
        File file = new File(DataBaseConstants.PRODUCT_DATA_PATH);
        if (file.exists()){
            productHashMap = readWriteUtil.read(DataBaseConstants.PRODUCT_DATA_PATH);
        }else {
            productHashMap = new HashMap<String, Product>();
        }

        productHashMap.put(p.getpId(), p);

        readWriteUtil.write(productHashMap, DataBaseConstants.PRODUCT_DATA_PATH);

        return true;
    }

    @Override
    public boolean removeProduct(String pId) throws Exception{
        HashMap<String, Product> productHashMap = readWriteUtil.
                read(DataBaseConstants.PRODUCT_DATA_PATH);

        productHashMap.remove(pId);

        readWriteUtil.write(productHashMap, DataBaseConstants.PRODUCT_DATA_PATH);

        return true;
    }

    @Override
    public boolean updateProduct(Product product) throws Exception{
        HashMap<String, Product> productHashMap = readWriteUtil.
                read(DataBaseConstants.PRODUCT_DATA_PATH);

        productHashMap.replace(product.getpId(),product);

        readWriteUtil.write(productHashMap, DataBaseConstants.PRODUCT_DATA_PATH);

        return true;
    }

    @Override
    public Product getProductById(String pId) throws Exception{
        HashMap<String, Product> productHashMap = readWriteUtil.
                read(DataBaseConstants.PRODUCT_DATA_PATH);

        Product product = productHashMap.get(pId);

        return product;
    }

    @Override
    public List<Product> getProductByName(String pName) throws Exception{
        ArrayList<Product> productsList = new ArrayList<Product>();
        HashMap<String, Product> productHashMap = readWriteUtil.
                read(DataBaseConstants.PRODUCT_DATA_PATH);
        Collection<Product> values = productHashMap.values();
        for (Product value:values){
            if (value.getpName().contains(pName)){
                productsList.add(value);
            }
        }
        return productsList;
    }

    @Override
    public List<Product> getProductByPrice(float minPrice, float maxPrice) throws Exception{
        ArrayList<Product> productsList = new ArrayList<Product>();
        HashMap<String, Product> productHashMap = readWriteUtil.
                read(DataBaseConstants.PRODUCT_DATA_PATH);
        Collection<Product> values = productHashMap.values();
        for (Product value:values){
            if (value.getPrice()>=minPrice && value.getPrice()<=maxPrice){
                productsList.add(value);
            }
        }
        return productsList;
    }

    @Override
    public List<Product> getProductByCategoryName(String categoryName) throws Exception{
        ArrayList<Product> productsList = new ArrayList<Product>();
        HashMap<String, Product> productHashMap = readWriteUtil.
                read(DataBaseConstants.PRODUCT_DATA_PATH);
        Collection<Product> values = productHashMap.values();
        for (Product value:values){
            if (value.getCategoryName().equals(categoryName)){
                productsList.add(value);
            }
        }
        return productsList;
    }
}
