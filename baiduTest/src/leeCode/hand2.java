package leeCode;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jing
 * @create 2020-04-12-16:39
 */
public class hand2 {
    public static void main(String[] args) {
        hand2 hand2 = new hand2();
        int[] ints = hand2.GetPowerFactor(39, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
    public int[] GetPowerFactor (int R, int N) {
        HashSet<Integer> set = new HashSet<>();
        int len = 0;
        while (R!=0){
            double i = 0;
            boolean flag = true;
            while (flag){
                if (Math.pow((double)N, i)<=R && Math.pow((double)N, i+1)>R){
                    R = R - (int)Math.pow((double)N, i);
                    set.add((int) i);
                    len++;
                    flag = false;
                }
                i = i + 1;
            }
        }
        if (len == set.size()){
            int[] re = new int[len];
            int i = 0;
            for (int a:set) {
                re[i] = a;
                i++;
            }
            return re;
        } else {
            return new int[]{};
        }
    }
}
