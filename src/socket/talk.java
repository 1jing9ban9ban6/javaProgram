package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class talk implements Runnable {
    public ServerSocket getSs() {
        return ss;
    }

    public void setSs(ServerSocket ss) {
        this.ss = ss;
    }

    public talk(ServerSocket ss) {
        this.ss = ss;
    }

    private ServerSocket ss;
    @Override
    public void run() {
        try {
            Socket sc = ss.accept();
            InputStream in = sc.getInputStream();
            OutputStream out = sc.getOutputStream();
            byte[] bytes = new byte[1024];
            int num = 0;
            // 第一次接受
            num = in.read(bytes);
            System.out.println(new String(bytes,0,num));

            // 第一次发送
            out.write("你好,".getBytes());

            // 第二次接收
            num = in.read(bytes);
            System.out.println(new String(bytes, 0, num));

            // 第二次发送
            out.write("好的再见".getBytes());

            out.close();
            in.close();
            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
