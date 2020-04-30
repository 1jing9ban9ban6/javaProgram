package socket;

import file.person;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class clientDemoFile {
  public static void main(String[] args) throws Exception{
      Socket sc = new Socket("127.0.0.1", 9997);
      OutputStream os = sc.getOutputStream();
      InputStream is = sc.getInputStream();
      ObjectInputStream ois = new ObjectInputStream(is);
      os.write("select * from pro.dat where name like xx".getBytes());


      ArrayList<person> pList = (ArrayList<person>)ois.readObject();
      System.out.println(pList);

      os.close();
      sc.close();
      ois.close();
  }
}
