package file;

import java.util.ArrayList;

public class highFileTest {
  public static void main(String[] args) throws Exception{
//
//      person p1 = new person("laowang",18,12.1f,true);
//      person p2 = new person("老王",22,15.3f,false);
//      person p3 = new person("xx",33,17.7f,true);
//      person p4 = new person("hh",23,42.4f,false);
//      person p5 = new person("jack",15,17.3f,true);
//      person p6 = new person("xx",19,10.3f,true);
//
      highFile highFile = new highFile();
//
//      highFile.addPerson(p1);
//      highFile.addPerson(p2);
//      highFile.addPerson(p3);
//      highFile.addPerson(p4);
//      highFile.addPerson(p5);
//      highFile.addPerson(p6);
      ArrayList<person> xx = highFile.getPersonByName("xx");
      System.out.println(xx);
  }
}
