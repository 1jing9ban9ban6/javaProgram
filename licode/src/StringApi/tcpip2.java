package StringApi;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author jing
 * @create 2020-02-29-20:13
 */
public class tcpip2 {
    @Test
    public void test1(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fos = null;
        InputStream sis = null;
        ByteArrayOutputStream baos = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8988);
            os = socket.getOutputStream();
            fos = new FileInputStream(new File("hello.txt"));
            byte[] bytes = new byte[5];
            int len;
            while ((len=fos.read(bytes))!=-1){
                os.write(bytes, 0, len);
            }
            socket.shutdownOutput();
            sis = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] bytess = new byte[5];
            int lens;
            while ((lens=sis.read(bytess))!=-1){
                baos.write(bytess, 0, lens);
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
                if (sis != null) {
                    sis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test2(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream sos = null;
        try {
            serverSocket = new ServerSocket(8988);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            fos = new FileOutputStream("D:/heihei.txt");
            byte[] bytes = new byte[5];
            int len;
            while ((len=is.read(bytes))!=-1){
                fos.write(bytes, 0, len);
            }
            sos = socket.getOutputStream();
            sos.write("我已收到，非常奈斯".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sos!=null){
                try {
                    sos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
