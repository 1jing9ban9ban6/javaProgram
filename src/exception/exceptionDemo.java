package exception;

import java.util.Scanner;

public class exceptionDemo {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String s = scanner.nextLine();
      int[] ints = new int[]{1,23,4,5,6};
      exceptionn ex= new exceptionn();

      while (true){
          int a = ex.array(ints, s);
          System.out.println(a);
      }
  }
}
