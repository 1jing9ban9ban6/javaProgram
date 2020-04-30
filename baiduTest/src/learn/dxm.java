package learn;

import java.util.*;

/**
 * @author jing
 * @create 2020-04-20-16:25
 */
public class dxm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[][] num = new int[n][m];
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[0].length; j++) {
                num[i][j] = (i + 1) * (j + 1) % 10;
            }
        }
        int x = n - a + 1;
        int y = m - b + 1;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int[][] temp = new int[a][b];
                for (int k = 0; k < a; k++) {
                    for (int l = 0; l < b; l++) {
                        temp[k][l] = num[i+k][j+l];
                    }
                }
                int re = maxNum(temp);
                sum = sum + re;
            }
        }
        System.out.println(sum);
    }

    private static int maxNum(int[][] temp) {
        int max = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                if (max < temp[i][j]) {
                    max = temp[i][j];
                }
            }
        }
        return max;
    }
}
