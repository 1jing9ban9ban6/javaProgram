package proShop.service;

import org.junit.Test;
import proShop.bin.product;

import java.util.ArrayList;

public class productServiceTest {
    @Test
    public void testAdd(){
        productServiceImpl productService = new productServiceImpl();
        String s = productService.addProduct("p01", "香皂", 2.5f, 10);
        System.out.println(s);
    }

    @Test
    public void testCheckByName(){
        productServiceImpl productService = new productServiceImpl();
        ArrayList<product> products = productService.checkProductByName("hah");
        System.out.println(products);
    }

    @Test
    public void testCheckByPrice(){
//        Scanner scanner = new Scanner(System.in);
//        String sc = scanner.nextLine();
        productServiceImpl productService = new productServiceImpl();
        ArrayList<product> products = productService.checkProductByPrice("5->10");
        System.out.println(products);
    }

    @Test
    public void testDelete(){
        productServiceImpl productService = new productServiceImpl();
        String re = productService.DeleteProductById("p04");
        System.out.println(re);
    }

    @Test
    public void testUpdateNameById(){
        productServiceImpl productService = new productServiceImpl();
        String re = productService.updateNameById("p04", "小刀");
        System.out.println(re);
    }

    @Test
    public void testCheckAllProduct(){
        productServiceImpl productService = new productServiceImpl();
        ArrayList<product> product = productService.checkAllProduct();
        System.out.println(product);
    }
}
