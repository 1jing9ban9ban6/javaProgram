package exception;

public class dev {
    public static void main(String[] args) {
          // 捕获异常
          int a = 3;
          int b = 0;
          try{
              int c = a/b;
          }catch (Exception e){
              System.out.println(e.getMessage());
          }
          System.out.println("后序代码");
    }
}
