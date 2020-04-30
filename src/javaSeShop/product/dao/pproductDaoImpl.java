package javaSeShop.product.dao;

import javaSeShop.bean.Product;
import javaSeShop.constants.DataBaseConstants;
import javaSeShop.fileOperateUtils.readWriteUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class pproductDaoImpl implements pproductDao {
    readWriteUtil<Product> readWriteUtil = new readWriteUtil<>();
    @Override
    public List<Product> getAllProduct() throws Exception{
        HashMap<String, Product> pHashMap = readWriteUtil.
                read(DataBaseConstants.PRODUCT_DATA_PATH);

        ArrayList<Product> pList = new ArrayList<>();
        Collection<Product> values = pHashMap.values();
        for (Product product:values){
            pList.add(product);
        }

        return pList;
    }

    @Override
    public List<Product> getProductByCateName(String cateName) throws Exception{
        HashMap<String, Product> pHashMap = readWriteUtil.
                read(DataBaseConstants.PRODUCT_DATA_PATH);

        ArrayList<Product> pList = new ArrayList<>();
        Collection<Product> values = pHashMap.values();
        for (Product product:values){
            if (product.getCategoryName().equals(cateName)){
                pList.add(product);
            }
        }
        return pList;
    }

    @Override
    public List<Product> getProductByPriceRange(float min, float max) throws Exception{
        HashMap<String, Product> pHashMap = readWriteUtil.
                read(DataBaseConstants.PRODUCT_DATA_PATH);

        ArrayList<Product> pList = new ArrayList<>();
        Collection<Product> values = pHashMap.values();
        for (Product product:values){
            if (product.getPrice()>=min && product.getPrice()<=max){
                pList.add(product);
            }
        }
        return pList;
    }

    @Override
    public Product getProductById(String Id) throws Exception{
        HashMap<String, Product> pHashMap = readWriteUtil.
                read(DataBaseConstants.PRODUCT_DATA_PATH);

        Product p = pHashMap.get(Id);

        return p;
    }

    @Override
    public boolean addProduct(Product product) throws Exception{
        HashMap<String, Product> pHashMap = readWriteUtil.
                read(DataBaseConstants.PRODUCT_DATA_PATH);

        pHashMap.put(product.getpId(), product);

        readWriteUtil.write(pHashMap, DataBaseConstants.PRODUCT_DATA_PATH);

        return true;
    }

    @Override
    public boolean updateProduct(Product product) throws Exception{
        HashMap<String, Product> pHashMap = readWriteUtil.
                read(DataBaseConstants.PRODUCT_DATA_PATH);

        pHashMap.replace(product.getpId(), product);

        readWriteUtil.write(pHashMap, DataBaseConstants.PRODUCT_DATA_PATH);

        return false;
    }
}
