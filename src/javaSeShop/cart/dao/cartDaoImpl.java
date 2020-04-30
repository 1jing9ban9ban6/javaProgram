package javaSeShop.cart.dao;

import javaSeShop.bean.CartItem;
import javaSeShop.constants.DataBaseConstants;
import javaSeShop.fileOperateUtils.readWriteUtil;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class cartDaoImpl implements cartDao {
    readWriteUtil<HashMap<String, CartItem>> CartUtil = new readWriteUtil();
    @Override
    public boolean addItemToCart(String userId, CartItem item) throws Exception {

        return true;
    }

    @Override
    public boolean removeItemFromCart(String userId, String pId) throws Exception {

        return false;
    }

    @Override
    public boolean updateItemBuyNum(String userId, String pId, int buyNum) throws Exception {
        return false;
    }

    @Override
    public List<CartItem> getAllItemsFromCart(String userId) throws Exception {
        return null;
    }

    @Override
    public boolean checkIfUserExist(String userId) {
        return false;
    }

    @Override
    public boolean checkIfItemExist(String userId, String pId) {
        return false;
    }

    @Override
    public boolean addNewUserItemToCart(String userId, CartItem cartItem) throws Exception{
        File file = new File(DataBaseConstants.CART_DATA_PATH);
        if (file.exists()){
            HashMap<String, HashMap<String, CartItem>> cartList = CartUtil.
                    read(DataBaseConstants.CART_DATA_PATH);
        }
        return false;
    }

    @Override
    public CartItem getItemById(String userId, String pId) {
        return null;
    }
}
