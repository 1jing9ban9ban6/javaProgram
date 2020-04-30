package socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class serviceDemo {
  public static void main(String[] args) throws Exception {
      // 启动一个socket服务端 本质就是向操作系统注册一个端口号，并且监听这个端口号的消息
      ServerSocket ss = new ServerSocket(10000);

      // 监听这个端口
      Socket sc = ss.accept(); // sc跑去监听这个端口，意思就是程序和操作系统建立了链接
      // 这是一个阻塞方法 就执行到这里就等着，一旦有人发了消息过来 才有返回值 程序才会继续
      // 向下执行
      // 从连接中接受数据 从socket链接中取数据 获取一个输入流工具
      InputStream is = sc.getInputStream();
      //从输入流中拿数据
//      int read = -1;
//      while ((read = is.read())!=-1){
//          char c = (char)read;
//          System.out.println(c);
//      }// read 也是一个阻塞的方法 没数据会一直在这里等待

      byte[] bytes = new byte[50];
      int read = is.read(bytes);
      System.out.println("收到客户端的数据是:" + new String(bytes, 0, read));

      OutputStream os = sc.getOutputStream();
      os.write("i m honghong。".getBytes());


      // 关闭服务
      os.close();
      is.close();
      ss.close();

  }
}
