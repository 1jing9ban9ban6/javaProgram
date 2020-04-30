package socket;

import java.net.ServerSocket;

public class serviceThreadDemo {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(9998);
        while (true){
            talk talk = new talk(ss);
            new Thread(talk).start();
        }
    }
}
