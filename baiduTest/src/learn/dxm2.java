package learn;

import java.util.Scanner;

/**
 * @author jing
 * @create 2020-04-20-17:03
 */
public class dxm2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = 0;
        int x = n - a + 1;
        int y = m - b + 1;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int max = 0;
                for (int k = 0; k < a; k++) {
                    for (int l = 0; l < b; l++) {
                        int temp = ((i + k + 1) * (j + l + 1) % 10);
                        if (max < temp) {
                            max = temp;
                        }
                    }
                }
                sum = sum + max;
            }
        }
        System.out.println(sum);
    }
}
