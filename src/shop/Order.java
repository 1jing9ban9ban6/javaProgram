package shop;

import java.util.ArrayList;

/*
    订单类
    订单ID
    订单所属用户（用户对象）
    订单所包含商品（不定数量的商品对象）
    订单总金额
    订单应付金额
* */
public class Order {

    // 订单ID
    public String orderId;

    // 订单所属用户（用户对象）
    public User user;

    // 订单所包含商品（不定数量的商品对象）
    public ArrayList<Product> pdts;

    // 订单总金额
    public float amountFee;

    // 订单应付金额
    public float toPay;

    public void setAmount(ArrayList<Product> arrayList) {
        float amount = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            amount += arrayList.get(i).price * arrayList.get(i).number;
        }
        this.amountFee = amount;
    }
    public void setToPayFee(){
        float temp = amountFee;
        if (this.amountFee >= 30 && this.amountFee < 50) {
            temp = this.amountFee * 0.98f;
        }
        if (this.amountFee >= 50 && this.amountFee < 80){
            temp = this.amountFee * 0.95f;
        }
        if (this.amountFee >= 80) {
            temp = this.amountFee * 0.90f;
        }
        // 再根据用户vip等级打折
        if (user.userLevel.equals("至尊")) {
            temp = temp * 0.92f;
        }
        if (user.userLevel.equals("铂金")) {
            temp = temp * 0.96f;
        }
        if (user.userLevel.equals("黄金")) {
            temp = temp * 0.98f;
        }
        this.toPay = temp;
    }
}
