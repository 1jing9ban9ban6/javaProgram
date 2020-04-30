package leeCode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jing
 * @create 2020-04-07-19:47
 * 4
 * 1 3 7 15
 */
public class testt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        long[] ints = new long[a];
        for (int i = 0; i < a; i++) {
            ints[i] = in.nextInt();
        }
//        int[] ints = {5, 5, 5};
        long r = re(ints);
        System.out.println(r);
    }
    public static long re(long [] nums){
        long[] ints = new long[nums.length - 1];
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1]-nums[i]<=0){
                return -1;
            }
            ints[i] = nums[i+1]-nums[i];
        }
        long[] sort = shellSort(ints);
        long re = -1;
        for (int i = sort.length-1; i >= 0 ; i--) {
            long temp = sort[i];
            for (int j = 0; j < sort.length; j++) {
                if (sort[j]%temp==0 && sort[j]!=re){
                    re = temp;
                } else {
                    break;
                }
            }
        }
        return re;
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
