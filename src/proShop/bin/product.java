package proShop.bin;

public class product {
    /** id name, price,库存数量   ***/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public int getKcNumber() {
        return kcNumber;
    }

    public void setKcNumber(int kcNumber) {
        this.kcNumber = kcNumber;
    }

    private int kcNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private float price;
    public product(String id, String name, float price, int kcNumber){
        this.id = id;
        this.name = name;
        this.price = price;
        this.kcNumber = kcNumber;
    }

    @Override
    public String toString() {
        return "product{" +
                "id='" + id + '\'' +
                ", kcNumber=" + kcNumber +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
