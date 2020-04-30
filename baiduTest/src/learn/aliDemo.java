package learn;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jing
 * @create 2020-04-10-9:10
 */
public class aliDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] ints = new long[n];
        for(int i = 0; i < n; i++){
            ints[i] = sc.nextInt();
            sc.nextInt();
        }
        long[] sort = shellSort(ints);
        System.out.println(minLen(sort));
    }
    public static long minLen(long [] arr){
        long len = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            len = len + (arr[arr.length-i-1] - arr[i]);
        }
        return len;
    }
    public static long[] shellSort(long[] ins) {
//      O(nLog n)
        int n = ins.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int j = gap; j < n; j++) {
                int i = j;
                while (i >= gap && ins[i - gap] > ins[i]) {
                    long temp = ins[i - gap] + ins[i];
                    ins[i - gap] = temp - ins[i - gap];
                    ins[i] = temp - ins[i - gap];
                    i -= gap;
                }
            }
            gap = gap / 2;
        }
        return ins;
    }
}
