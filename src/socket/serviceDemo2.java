package socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class serviceDemo2 {
  public static void main(String[] args) throws Exception {
      // 构造服务端的socket
      ServerSocket ss = new ServerSocket(9999);
      Socket sc = ss.accept();
      OutputStream out = sc.getOutputStream();
      InputStream in = sc.getInputStream();
      byte[] bytes = new byte[1024];
      int num = 0;

      // 第一次接受
      num = in.read(bytes);
      System.out.println(new String(bytes,0,num));

      // 第一次发送
      out.write("你好这里是9999服务器,".getBytes());

      // 第二次接收
      num = in.read(bytes);
      System.out.println(new String(bytes, 0, num));

      // 第二次发送
      out.write("好的再见".getBytes());

      out.close();
      in.close();
      sc.close();
      ss.close();
  }
}
