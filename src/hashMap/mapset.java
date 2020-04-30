package hashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class mapset {
  public void quChong(String s){
      // 将字符串分割
      String[] split = s.split(",");
      // 构造hashset完成对字符串的去重
      HashSet<String> hashSet = new HashSet<>();
      for (int i = 0; i < split.length; i++){
          hashSet.add(split[i]);
      }
      for(String temp : hashSet){
          System.out.println(temp);
      }
  }
  public void tongJi(String s){
      // 统计字符串各个字符的个数
      HashMap<String, Integer> map = new HashMap<>();
      String[] split = s.split(",");
      for (int i = 0; i < split.length; i++){
          if(map.containsKey(split[i])){
              int num = map.get(split[i]);
              map.put(split[i], num + 1);
          }
          else{
              map.put(split[i], 1);
          }
      }
      Set<Map.Entry<String, Integer>> entries = map.entrySet();
      for(Map.Entry entry : entries){
          System.out.println(entry.getKey()+","+entry.getValue());
      }
  }
}
