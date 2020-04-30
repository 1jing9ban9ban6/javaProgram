package leeCode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author jing
 * @create 2020-04-02-20:51
 */
public class test2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        ArrayList<Double> p = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) {
//            p.add(sc.nextDouble());
//        }
//        ArrayList<Integer> a = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) {
//            a.add(sc.nextInt());
//        }
        ArrayList<Double> p = new ArrayList<>();
        p.add(0.8);
        p.add(0.5);
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        System.out.println(ex(p, a));
    }
    public static Double ex(ArrayList<Double> p, ArrayList<Integer> a){
        int n = p.size();
        Double re = 1.0;
        for (int i = 0; i < n; i++) {
            re = re*Math.pow(p.get(0), i+1)*a.get(0)+re;
        }
        return re;
    }
}
