package socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class clientDemo2 {
    public static void main(String[] args) throws Exception{
        // 构造客户端的socket
        Socket sc = new Socket("127.0.0.1", 9998);

        OutputStream out = sc.getOutputStream();
        InputStream in = sc.getInputStream();
        byte[] bytes = new byte[1024];
        int num = 0;

        // 第一次发送
        out.write("在么,".getBytes());

        // 第一次接收
        num = in.read(bytes);
        System.out.println(new String(bytes,0,num));

        // 第二次发送
        out.write("没事就是问问".getBytes());

        // 第二次接收
        num = in.read(bytes);
        System.out.println(new String(bytes, 0, num));

        out.close();
        in.close();
        sc.close();
    }
}
