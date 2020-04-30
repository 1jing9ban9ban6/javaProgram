package file;

import java.io.FileOutputStream;

public class outPut {
  public static void main(String[] args) throws Exception{
      // 向文件中写入数据
      FileOutputStream fops = new FileOutputStream("G:/flie/hello.txt",true);
      String s = "nihao的";
      byte[] b = s.getBytes();
      fops.write(b);
      fops.close();
  }
}
