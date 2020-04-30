package sortUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class sortTest {
  public static void main(String[] args) {
      user u1 = new user("01", "a", 1f);
      user u2 = new user("02", "b", 2f);
      user u3 = new user("03", "c", 3f);
      user u4 = new user("04", "d", 4f);
      user u5 = new user("05", "e", 5f);

      ArrayList<user> usersArr = new ArrayList<user>();
      usersArr.add(u1);
      usersArr.add(u2);
      usersArr.add(u3);
      usersArr.add(u4);
      usersArr.add(u5);

      sortU<user> sortU = new sortU<>();
      sortU.sort(usersArr, new bijiaoqiImpl());


      shangPin s1 = new shangPin("01","a",1.1f,20);
      shangPin s2 = new shangPin("02","b",2.1f,10);
      shangPin s3 = new shangPin("03","c",1.3f,32);
      shangPin s4 = new shangPin("04","d",1.5f,13);
      shangPin s5 = new shangPin("05","e",3.1f,22);
      ArrayList<shangPin> SP = new ArrayList<shangPin>();
      SP.add(s1);
      SP.add(s2);
      SP.add(s3);
      SP.add(s4);
      SP.add(s5);

      sortUtil.sortU<shangPin> shangPinsortU = new sortU<>();
      shangPinsortU.sort(SP, new pricebijiao());


      shangPinsortU.sort(SP, new bijiaoqi<shangPin>(){
          @Override
          // 匿名内部类
          public boolean bijiao(shangPin o1, shangPin o2) {
              if(o1.getKcNumber()>o2.getKcNumber()){
                  return true;
              }
              return false;
          }
      });
      Collections.sort(SP, new Comparator<shangPin>() {
          @Override
          public int compare(shangPin o1, shangPin o2) {
              float re = o1.getKcNumber()-o2.getKcNumber();
              if(re>0){
                  return -1;
              }
              return 1;
          }
      });
//      for (shangPin pin : SP){
//          System.out.println(pin);
//      }
      // 类中自定义 比较方式
      sortPUTong sortPUTong = new sortPUTong();
      sortPUTong.sort(SP);
//      for (shangPin pin : SP){
//          System.out.println(pin);
//      }
      // jdk框架中的Collections也能进行比较，
      Collections.sort(SP);
      for (shangPin pin : SP){
          System.out.println(pin);
      }
  }

}
