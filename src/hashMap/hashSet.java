package hashMap;

import java.util.HashSet;
import java.util.Iterator;

public class hashSet {
  public static void main(String[] args) {
      /**
       * hashset是一个集合数据类型，一个具体的hashset中可以装入多个数据
       * 不能重复
       *  且无序
       */
      HashSet<String> set = new HashSet<>();
      set.add("bengshaka");
      set.add("laka");
      set.add("lad");
      set.size();// 长度
//      set.remove("laka");
      Iterator<String> iterator = set.iterator();
      while (iterator.hasNext()){
          System.out.println(iterator.next());
      }

  }
}
