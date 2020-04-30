package Thread;

public class threadDemo {
  public static void main(String[] args) {
      demo1 d11 = new demo1();
      demo1 d12 = new demo1();
      demo1 d13 = new demo1();
      demo2 d2 = new demo2();
      Thread thread1 = new Thread(d11);
      Thread thread2 = new Thread(d12);
      Thread thread3 = new Thread(d13);
      Thread thread4 = new Thread(d2);
      Thread thread5 = new Thread(d2);

//      // 启动线程 按顺序
//      thread1.run();
//      thread2.run();
//      thread3.run();
//      thread4.run();
//      thread5.run();

      // 启动线程 不按顺序
      thread1.start();
      thread2.start();
      thread3.start();
      thread4.start();
      thread5.start();
  }
}
