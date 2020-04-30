package javaSeShop.cart.service;

import javaSeShop.bean.CartItem;
import javaSeShop.bean.Product;
import javaSeShop.cart.dao.cartDao;
import javaSeShop.fileOperateUtils.readWriteUtil;
import javaSeShop.product.dao.productDao;
import javaSeShop.product.dao.productDaoImpl;

import java.util.List;

public class cartServiceImpl implements cartService {
    cartDao cartDao = null;
    productDao productDao = new productDaoImpl();
    readWriteUtil<Product> pUtil = new readWriteUtil();
    @Override
    public boolean addItemToCart(String userId, String pId, int buyNum)
            throws Exception{
        boolean add;
        // 判断用户在购物车
        boolean b1 = cartDao.checkIfUserExist(userId);
        if (b1){
            // 该用户存在
            boolean b = cartDao.checkIfItemExist(userId, pId);
            if (b){
                // 取这个人之前的数量
                CartItem item = cartDao.getItemById(userId, pId);
                add = cartDao.updateItemBuyNum(userId, pId, buyNum + item.getBuyNum());
            }else {
                Product product= productDao.getProductById(pId);

                CartItem cartItem = new CartItem(pId, product.getpName(),
                        product.getPrice(), buyNum);
                // 把用户添加到已有的购物车数据中
                add = cartDao.addItemToCart(userId, cartItem);
            }
        }else {
            // 该用户没有买过商品
            Product product= productDao.getProductById(pId);

            CartItem cartItem = new CartItem(pId, product.getpName(),
                    product.getPrice(), buyNum);
            // 利用购物车dao将这个购物项新增到购物车中
            add = cartDao.addNewUserItemToCart(userId, cartItem);
        }

        return add;
    }

    @Override
    public boolean removeItemFromCart(String userId, String pId)
            throws Exception{

        boolean b = cartDao.removeItemFromCart(userId, pId);

        return b;
    }

    @Override
    public boolean updateItemBuyNum(String userId, String pId, int buyNum)
            throws Exception{
        cartDao.updateItemBuyNum(userId, pId, buyNum);
        return false;
    }

    @Override
    public List<CartItem> getAllItem(String userId) throws Exception{
        List<CartItem> allItemsFromCart = cartDao.getAllItemsFromCart(userId);
        return allItemsFromCart;
    }
}
