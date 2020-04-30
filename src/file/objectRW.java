package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class objectRW {
  public static void main(String[] args) throws Exception{
    ObjectOutputStream oops = new ObjectOutputStream(
            new FileOutputStream("G:/flie/hello.txt"));
      person p1 = new person("小王",12,1800f,false);
      person p2 = new person("小李",14,1800f,false);
      person p3 = new person("小吴",57,1800f,true);
      person p4 = new person("小郑",25,1800f,true);
      person p5 = new person("小张",16,1800f,false);
      // 要求对象是可序列化的才行
      oops.writeObject(p1);
      oops.writeObject(p2);
      oops.writeObject(p3);
      oops.writeObject(p4);
      oops.writeObject(p5);
      oops.close();

      ObjectInputStream ois = new ObjectInputStream(
              new FileInputStream("G:/flie/hello.txt"));
      person p = null;
      while ((p = (person) ois.readObject())!=null){
          System.out.println(p);
      }

      ois.close();
  }
}
