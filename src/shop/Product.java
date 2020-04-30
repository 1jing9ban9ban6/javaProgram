package shop;

import java.util.ArrayList;

// 商品类
public class Product {
    public String pId;
    public String pName;
    public float price;
    public int number;


    public Product() {

    }


    public Product(String pId, String pName, float price, int number) {
        this.pId = pId;
        this.pName = pName;
        this.price = price;
        this.number = number;
    }


    public String toString() {
        String str = this.pId+","+this.pName+","+this.price+","+this.number;
        return str;
    }


    public static float getAmount(ArrayList<Product> arrayList) {
        float amount = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            amount += arrayList.get(i).price * arrayList.get(i).number;
        }
        return amount;
    }

    public float getAmount(){
        return this.price * this.number;
    }
}
