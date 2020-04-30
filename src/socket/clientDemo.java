package socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class clientDemo {
  public static void main(String[] args) throws Exception{
      // 向服务端发出建立连接的请求
      Socket sc = new Socket("127.0.0.1", 10000);
      // 从连接中拿到一个发送数据的方法
      OutputStream os = sc.getOutputStream();
      os.write("who are you".getBytes());

      InputStream is = sc.getInputStream();
      byte[] bytes = new byte[50];
      int read = is.read(bytes);
      System.out.println(new String(bytes, 0, read));

      is.close();
      os.close();
      sc.close();
  }
}
