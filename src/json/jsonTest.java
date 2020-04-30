package json;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class jsonTest {
  public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(
              new FileInputStream("G:/flie/rating.json")));
      String s = null;
      while ((s = br.readLine()) != null) {
          MoiveRate moiveRate = jsonDemo.parseLine(s);
          System.out.println(moiveRate);
      }
  }
}
