package file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class testDemo {
  public static void main(String[] args) throws Exception {
      BufferedReader bf = new BufferedReader(new InputStreamReader(
              new FileInputStream("G:/flie/hello.txt"), "gbk"));
      String s ="";
      HashMap<String, Integer> sshm = new HashMap<String, Integer>();
      while ((s = bf.readLine()) != null) {
      String[] s1 = s.split(" ");
          for (String value : s1) {
              if (sshm.containsKey(value)) {
                  int num = sshm.get(value);
                  sshm.put(value, num + 1);
              } else {
                  sshm.put(value, 1);
              }
          }

      }
      Set<Map.Entry<String, Integer>> entries = sshm.entrySet();
      for (Map.Entry entry : entries) {
          System.out.println(entry.getKey() + "," + entry.getValue());
      }
  }
}
