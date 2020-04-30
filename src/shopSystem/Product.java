package shopSystem;

public class Product {
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    private String productId;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    private String productName;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private float price;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private int num;

    public String toString(){
        return this.productId+","+this.productName+","+this.price;
    }
    public String toString1(){
        return this.productId+","+this.productName+","+this.price+","+this.num;
    }
    public Product(String productId, String productName, float price){
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }
    public Product(){

    }
}
