package proShop.Dao;

import proShop.bin.product;

import java.util.ArrayList;

public interface productDao {
    public void addProduct(String id, String name, float price, int kcNumber);
    public ArrayList<product> checkAllProduct();
    public product checkProductById(String id);
    public ArrayList<product> checkProductByName(String name);
    public ArrayList<product> checkProductByPrice(float a, float b);
    public void DeleteProductById(String id);
    public void updateNameById(product product, String name);
    public void updatePriceById(product product, float price);
    public void updateKcNumById(product product, int kcNumber);
}
