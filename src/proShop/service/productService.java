package proShop.service;

import proShop.bin.product;

import java.util.ArrayList;

public interface productService {
//      1、用户可以通过输入商品信息来向库中添加商品，如：
    public String addProduct(String id, String name, float price, int kcNumber);

//      2、用户可以查看数据库中所有的商品
    public  ArrayList<product> checkAllProduct();

//      3、用户可以通过输入一个id来查看一个商品
    public product checkProductById(String id);

//    4、用户可以通过输入一个name来查看一个商品
    public ArrayList<product> checkProductByName(String name);

//    5、用户可以通过输入一个价格范围（比如： 100->200）来查看符合条件的商品
    public ArrayList<product> checkProductByPrice(String price_s);

//    6、用户可以通过输入一个id来从数据库中删除一个商品
    public String DeleteProductById(String id);

//    7、用户可以通过指定一个id来修改一个商品的名称
    public String updateNameById(String id, String name);

//    8、用户可以通过制定一个id来修改一个商品的价格
    public String updatePriceById(String id, float price);

//    9、用户可以通过制定一个id来修改一个商品的库存数量
    public String updateKcNumById(String id, int kcNum);
}
