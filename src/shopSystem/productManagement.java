package shopSystem;

import java.util.ArrayList;

public class productManagement {
    private ArrayList<Product> pdts = new ArrayList<>();

    public ArrayList<Product> getPdts(){
        return this.pdts;
    }

    // 添加商品
    public void addProduct(Product product){
        this.pdts.add(product);
    }
    // 展示商品
    public void showProduct(){
        for (int i = 0; i < this.pdts.size(); i++){
            System.out.println(this.pdts.get(i).toString());
        }
    }
    /* 给我一个id，我还你一个对象*/
    public Product selcetById(String id, String num){
        ArrayList<Product> pdts = this.getPdts();
        for(int i = 0; i < pdts.size(); i++){
            Product product = pdts.get(i);
            if (product.getProductId().equals(id)){
                product.setNum(Integer.parseInt(num));
                return product;
            }
        }
        return null;
    }
}
