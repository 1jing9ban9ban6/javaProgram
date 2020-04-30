package shop;

import java.util.ArrayList;

public class shopTest {
    public static void main(String[] args) {
        User u1 = new User("01", "张三", "铂金");
        User u2 = new User("02", "李四", "黄金");
        User u3 = new User("03", "王五", "至尊");

        Product p1 = new Product("01", "肥皂", 2.5f, 2);
        Product p2 = new Product("02", "手铐", 25.5f, 2);
        Product p3 = new Product("03", "电棍", 15.5f, 1);
        Product p4 = new Product("04", "眼镜", 15.5f, 1);

        ArrayList<Product> ps = new ArrayList<>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);

        Order o1 = new Order();
        o1.orderId = "1";
        o1.user = u1;
        o1.pdts = ps;
        o1.setAmount(ps);
        o1.setToPayFee();

        System.out.println("订单总金额:"+o1.amountFee+",实际付款:"+o1.toPay);
    }
}
