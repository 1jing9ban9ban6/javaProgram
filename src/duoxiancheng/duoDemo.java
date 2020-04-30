package duoxiancheng;

public class duoDemo {
  public static void main(String[] args) {
      duoxiancheng d = new duoxiancheng(100);
      for (int i=0 ;i<10;i++) {
          new Thread(d).start();
      }
  }
}
