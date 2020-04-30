package questionL;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jing
 * @create 2020-03-31-20:45
 */
public class LockDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new ConcurrentHashMap<>();
        String s1 = sc.nextLine();
        if (s1.equals("1L")) {
            String s2 = sc.nextLine();
            if (s2.equals("3R")) {
                String s3 = sc.nextLine();
                if (s3.equals("2L")) {
                    System.out.println("正确，已开锁");
                }
            } else {
                System.out.println("输入错误，报警");
                System.exit(0);
            }
        } else {
            System.out.println("输入错误，报警");
            System.exit(0);
        }
    }
}
