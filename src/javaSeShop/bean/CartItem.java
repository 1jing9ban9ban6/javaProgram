package javaSeShop.bean;

public class CartItem {
    private String pId;
    private String pName;
    private float price;
    private int buyNum;

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public CartItem() {
    }

    public CartItem(String pId, String pName, float price, int buyNum) {
        this.pId = pId;
        this.pName = pName;
        this.price = price;
        this.buyNum = buyNum;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "pId='" + pId + '\'' +
                ", pName='" + pName + '\'' +
                ", price=" + price +
                ", buyNum=" + buyNum +
                '}';
    }
}
