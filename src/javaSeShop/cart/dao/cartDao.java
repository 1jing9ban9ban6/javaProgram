package javaSeShop.cart.dao;

import javaSeShop.bean.CartItem;

import java.util.List;

public interface cartDao {
    public boolean addItemToCart(String userId, CartItem item) throws Exception;
    public boolean addNewUserItemToCart(String userId, CartItem cartItem) throws Exception;
    public boolean removeItemFromCart(String userId, String pId) throws Exception;
    public boolean updateItemBuyNum(String userId, String pId, int buyNum) throws Exception;
    public List<CartItem> getAllItemsFromCart(String userId) throws Exception;
    public boolean checkIfUserExist(String userId);
    public boolean checkIfItemExist(String userId, String pId);
    public CartItem getItemById(String userId, String pId);

}

