package file;

import java.io.File;
import java.io.FileInputStream;

public class helloFile {
  public static void main(String[] args) throws Exception {
      File file = new File("G:/flie/hello.txt");
      FileInputStream fis = new FileInputStream(file);
//      int read = 0;
//      while ((read = fis.read())!=-1){
//          char c = (char)read;
//          System.out.println(c);
//      }
      byte[] b = new byte[8];
      int num = fis.read(b);
      String s = new String(b,0,8);
      System.out.println(s);
  }


}
