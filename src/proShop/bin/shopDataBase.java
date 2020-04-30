package proShop.bin;

import java.util.HashMap;

public class shopDataBase {
    public static HashMap<String, product> shopDB = new HashMap<>();
    static {
        /*p01,透明胶带,8.8,1000*/
        product p1 = new product("p01","透明胶带", 8.8f,1000);
        product p2 = new product("p02","钢笔", 2.5f,800);
        product p3 = new product("p03","橡皮", 0.5f,200);
        product p4 = new product("p04","橡皮", 0.5f,200);
        shopDB.put(p1.getId(),p1);
        shopDB.put(p2.getId(),p2);
        shopDB.put(p3.getId(),p3);
        shopDB.put(p4.getId(),p4);
    }

}
