package shopSystem;

import java.util.Scanner;

public class shopMenu {
  public static void main(String[] args) {
      // 创建和加载商品
      productManagement pm = new productManagement();
      createProduct.create(pm);
      // 创建购物车
      cartManagement cm = new cartManagement();
      System.out.println("欢迎来到小牛商城，请选择您要进行的操作:");
      boolean flag = true;
      Scanner scanner = new Scanner(System.in);
      while (flag){
          System.out.println("1.浏览商品;2.购物;3.查看购物车;4.修改购物车;5.提交订单;6.付款;7.退出");
          String command = scanner.nextLine();
          switch (command){
              case "1":
                  pm.showProduct();
                  break;
              case "2":
                  System.out.println("请选择您要购买的商品，格式如:pdt1:1,pdt2:3");
                  String scanf = scanner.nextLine();
                  cm.addProductToCart(scanf, pm);
                  break;
              case "3":
                  cm.showCart();
                  break;
              case "4":
                  System.out.println("修改");
                  break;
              case "5":
                  System.out.println("提交了订单");
                  break;
              case "6":
                  System.out.println("付款了");
                  break;
              case "7":
                  flag = false;
                  break;
              default:
                  System.out.println("请输入正确的提示");
                  break;
          }
      }


  }
}
