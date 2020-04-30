import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author jing
 * @create 2020-02-29-17:58
 */
public class tcpip {
    public static void main(String[] args) throws UnknownHostException {
        // 获取ip地址的实例化 inetAddress.getbyname 通信要素1 叫ip 另一个要素叫端口号
        // 端口号表示不同的进程 就是不同的程序 我想和那个程序进行通信 0-65535 个端口
        // 0-1023 倍一些服务占了一些端口号
        // 1024-49151 是一些分被给用胡进程火应用程序  不能和别的冲突 所以就是一个不能冲突
        // 启动两个tomcat 一个8080 一个8989 不同进程不同端口号
        // 俩人一块 就socket 编程
        InetAddress name = InetAddress.getByName("127.0.0.1");
        System.out.println(name);
        InetAddress name1 = InetAddress.getByName("www.mi.com");
        System.out.println(name1);
        InetAddress host = InetAddress.getLocalHost();
        System.out.println(host);
    }

    @Test
    public void test1() {
        OutputStream os = null;
        try {
            // 通信要素2
            // 传输层 tcp udp 有什么区别 tcp三次握手 四次挥手  太nm啦
            Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8988);
            os = socket.getOutputStream();
            os.write("这里是客服".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() throws Exception {
        ServerSocket socket = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            socket = new ServerSocket(8988);
            accept = socket.accept();// 接受来自客户端的socket
            is = accept.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[5];
            int len;
            while ((len = is.read(bytes)) != -1) {
                baos.write(bytes, 0, len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (baos != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (baos != null) {
                    accept.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (baos != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
