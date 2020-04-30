package hashMap;

import java.util.HashMap;
import java.util.Set;

public class hashMapDemo {
  public static void main(String[] args) {
    // 构造一个hashMap 对象
      HashMap<String, String> sshm = new HashMap<>();
      // 往hashMap放数据如果key重复那么值就会覆盖
      sshm.put("1","莱昂纳多");
      sshm.put("2","高高");
      sshm.put("3","花里胡哨");
      sshm.put("4","j");
      sshm.put("5","迪克");
      sshm.put("6","不累");
      sshm.put("7","凡思");
      sshm.put("8","饭");
      // 取数据
      String s1 = sshm.get("1");
      System.out.println(s1);
      // 移除数据
//      String remove = sshm.remove("2");
//      System.out.println(remove);
      // 检验是否存在
//      String s2 = sshm.get("2");
//      System.out.println(s2);
//      boolean b = sshm.containsKey("2"); // 此方法才能正确检验是否移除
//      System.out.println(b);
      // hash map的遍历 需要借助一下set集合把map里所有的key返回成一个set然后用set的迭代器来进行遍历
      Set<String> keys = sshm.keySet();
      for(String key : keys){
          System.out.println(sshm.get(key));
      }
  }
}
