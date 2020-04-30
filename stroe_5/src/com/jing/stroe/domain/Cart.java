package com.jing.stroe.domain;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String, CartItem> cart = new HashMap<String, CartItem>(); // 不确定数量的购物项
    private double total; // 总价钱
    public void addCartItemToCart(CartItem cartItem){
        String pid = cartItem.getProduct().getPid();
        // 添加购物项到购物车
        if (cart.containsKey(pid)){
            // 如果已经存在该商品，将商品的数量修改
            CartItem oldItem = cart.get(pid);
            oldItem.setNum(oldItem.getNum()+cartItem.getNum());
        } else {
            // 如果没有买过该商品，向map里面添加该商品
            cart.put(pid, cartItem);
        }
    }

    public Collection<CartItem> getCartItem(){
        return cart.values();
    }

    public void removeCartItem(String pid){
        // 移除购物项
        cart.remove(pid);
    }

    public void clearCart(){
        // 清空购物车
        cart.clear();
    }

    public Map<String, CartItem> getCart() {
        return cart;
    }

    public void setCart(Map<String, CartItem> cart) {
        this.cart = cart;
    }

    public double getTotal() {
        total = 0;
        Collection<CartItem> values = cart.values();
        for (CartItem cartItem:values){
            total = cartItem.getSubTotal() + total;
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
