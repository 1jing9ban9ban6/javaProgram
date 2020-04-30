package com.jing.factory;

/**
 * @author jing
 * @create 2020-03-05-20:56
 */
public class car {
    private String brand;
    private Double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
