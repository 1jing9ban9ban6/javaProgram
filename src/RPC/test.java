package RPC;

import file.person;

import java.util.ArrayList;

public class test {
  public static void main(String[] args) throws Exception{
      readDataUtil readDataUtil = new readDataUtil();
      highFile instance = readDataUtil.getInstance();
      person personById = instance.getPersonById(3);
//      System.out.println(personById);
      ArrayList<person> xx = instance.getPersonByName("xx");
      System.out.println(xx);
  }
}
