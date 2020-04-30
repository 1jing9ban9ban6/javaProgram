package ArrayList;

import shop.Product;

import java.util.ArrayList;

public class ListDemo2 {
    public static void main(String[] args) {
        Product p1 = new Product();
        p1.pId = "01";
        p1.pName = "肥皂";
        p1.price = 2.5f;
        p1.number = 2;

        Product p2 = new Product();
        p2.pId = "02";
        p2.pName = "手铐";
        p2.price = 25.5f;
        p2.number = 2;

        Product p3 = new Product();
        p3.pId = "03";
        p3.pName = "电棍";
        p3.price = 15.5f;
        p3.number = 1;

        Product p4 = new Product();
        p4.pId = "04";
        p4.pName = "眼镜";
        p4.price = 20.5f;
        p4.number = 1;

        ArrayList<Product> ps = new ArrayList<>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);

        // 计算list列表商品总金额
//        float amount = 0;
//        for (int i = 0; i < ps.size(); i++) {
//            amount += ps.get(i).price * ps.get(i).number;
//        }
//        System.out.println(amount);
        float amount = Product.getAmount(ps);
        System.out.println(amount);
        // 计算list中的所有商品中成交金额最大的商品


        // 所有商品中单价最高的商品
        Product temp_p = new Product();
        temp_p = p1;
        for (int i = 1; i < ps.size(); i++) {
            if (temp_p.price < ps.get(i).price) {
                temp_p = ps.get(i);
            }
        }
//        System.out.println(temp_p.pName+"单价最高，为："+temp_p.price);
    }
}
