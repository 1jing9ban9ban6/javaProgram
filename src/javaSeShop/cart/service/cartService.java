package javaSeShop.cart.service;

import javaSeShop.bean.CartItem;

import java.util.List;

public interface cartService {
    public boolean addItemToCart(String userId, String pId, int buyNum) throws Exception;
    public boolean removeItemFromCart(String userId, String pId) throws Exception;
    public boolean updateItemBuyNum(String userId, String pId, int buyNum) throws Exception;
    public List<CartItem> getAllItem(String userId) throws Exception;

}
