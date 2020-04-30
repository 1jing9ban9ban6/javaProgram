package shopSystem;

import java.util.ArrayList;

public class cartManagement {
    private ArrayList<Product> cart = new ArrayList<>();
    public void addProductToCart(String scanf, productManagement pm){
        // 往购物车里添加商品格式如:pdt1:1,pdt2:3
        String[] thing = scanf.split(",");
        for (int i = 0; i < thing.length; i++){
            // 将商品的id和数量先添加到商品信息里面
            String[] pdtAndNum = thing[i].split(":");
            Product product = pm.selcetById(pdtAndNum[0], pdtAndNum[1]);
            cart.add(product);
        }
    }
    // 从购物车里移除商品

    // 打印购物车信息
    public void showCart(){
        for(int i = 0; i < this.cart.size(); i++){
            System.out.println(this.cart.get(i).toString1());
        }
    }
    // 修改购物车中商品数量
}
