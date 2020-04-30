package socket;

import file.highFile;

import java.net.ServerSocket;
import java.net.Socket;

public class DBService {
  public static void main(String[] args) throws Exception{
      ServerSocket ss = new ServerSocket(9997);
      highFile hf = new highFile();
      while (true){
          Socket sc = ss.accept();
          talk2 t = new talk2(sc, hf);
          new Thread(t).start();
      }
  }
}
