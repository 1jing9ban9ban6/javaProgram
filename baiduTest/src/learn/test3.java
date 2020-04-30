package learn;

import java.lang.management.ManagementFactory;

/**
 * @author jing
 * @create 2020-04-27-18:01
 */
public class test3 {
    public static void main(String[] args) {
        int [] num = {2,5,7,9,11,15};
        int a = 16;
        int[] add = test3.add(num, a);
        for (int i = 0; i < add.length; i++) {
            System.out.println(add[i]);
        }
    }
    public static int[] add(int [] num, int a){
        int[] ints = new int[num.length + 1];
        int m = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i]<a){
                ints[i] = num[i];
            } else {
                ints[i] = a;
                m = i;
                break;
            }
        }
        for (int i = m+1; i < ints.length; i++) {
            ints[i] = num[i-1];
        }
        return ints;
    }
}
