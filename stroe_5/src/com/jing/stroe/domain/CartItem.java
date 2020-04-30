package com.jing.stroe.domain;

public class CartItem {
    private Product product; // 为了获取购物项的图片路径，商品名称，商品价格
    private int num; // 当前购物商品的数量
    private double subTotal; // 小计

    public double getSubTotal(){
        // 计算 商品的小计 就是单个商品的总价格
        return product.getShop_price() * num;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
