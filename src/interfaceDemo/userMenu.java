package interfaceDemo;

import interfaceDemo.service.UserService;
import interfaceDemo.service.UserServiceImpl;

import java.util.Scanner;

public class userMenu {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      UserService um = new UserServiceImpl();
      boolean flag = true;
      while (flag){
          System.out.println("1:登陆      2:注册       3:退出");
          String s = sc.nextLine();
          switch (s) {
              case "1":
              System.out.println("请输入账号");
              String userName = sc.nextLine();
              System.out.println("请输入密码");
              String passWord = sc.nextLine();
              // 调用业务逻辑组件的登陆方法
              boolean login = um.login(userName, passWord);
              if (login) {
                System.out.println("登陆成功");
              } else {
                System.out.println("用户名或密码错误");
              }
              break;
                case "2":
                  System.out.println("请输入用户名");
                  String name = sc.nextLine();
                  System.out.println("请输入密码");
                  String pwd = sc.nextLine();
                  System.out.println("请再次输入密码");
                  String pwd1 = sc.nextLine();
                  String zhuCe = um.zhuCe(name, pwd, pwd1);
                  switch (zhuCe) {
                    case "1":
                      System.out.println("两次密码不一致");
                      break;
                    case "2":
                      System.out.println("用户名已经被注册");
                      break;
                    case "3":
                      System.out.println("注册成功");
                      break;
                    default:
                      break;
                  }
              case "3":
                  flag = false;
                  System.out.println("bye...........");
                  break;
              default:
                  break;
          }
      }
  }
}
