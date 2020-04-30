package shopSystem;

public class createProduct {
    public static void create(productManagement pm){
        Product p1 = new Product("01", "拖鞋", 18f);
        Product p2 = new Product("02", "毛巾", 20f);
        Product p3 = new Product("03", "沐浴露", 25f);
        Product p4 = new Product("04", "洗发水", 30f);
        Product p5 = new Product("05", "牙膏", 5f);
        Product p6 = new Product("06", "牙刷", 7f);
        Product p7 = new Product("07", "洗面奶", 30f);
        Product p8 = new Product("08", "搓澡巾", 3f);
        Product p9= new Product("09", "水卡", 50f);
        Product p10 = new Product("10", "脸盆", 16f);
        pm.addProduct(p1);
        pm.addProduct(p2);
        pm.addProduct(p3);
        pm.addProduct(p4);
        pm.addProduct(p5);
        pm.addProduct(p6);
        pm.addProduct(p7);
        pm.addProduct(p8);
        pm.addProduct(p9);
        pm.addProduct(p10);
    }

}
