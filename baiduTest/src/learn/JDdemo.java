package learn;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * @author jing
 * @create 2020-04-18-19:41
 */
public class JDdemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            HashMap<Set<Integer>, Integer> map = new HashMap<>();
            for (int j = 0; j < 6; j++) {
                Set<Integer> tempSet = new HashSet<>();
                tempSet.add(in.nextInt());
                tempSet.add(in.nextInt());
                if (map.get(tempSet) == null){
                    map.put(tempSet, 1);
                } else {
                    map.put(tempSet, map.get(tempSet) + 1);
                }
            }
            if (map.size()==1){
                Set<Set<Integer>> sets = map.keySet();
                for (Set<Integer> set: sets ) {
                    if (set.size()==1){
                        System.out.println("POSSIBLE");
                    } else {
                        System.out.println("IMPOSSIBLE");
                    }
                }
            } else if (map.size()==2){
                Collection<Integer> values = map.values();
                for (Integer integer: values) {
                    if (integer % 2==1){
                        System.out.println("IMPOSSIBLE");
                        return;
                    }
                }
                System.out.println("POSSIBLE");
            } else if (map.size() == 3){
                Collection<Integer> values = map.values();
                for (Integer integer: values) {
                    if (integer != 2){
                        System.out.println("IMPOSSIBLE");
                        return;
                    }
                }
                System.out.println("POSSIBLE");
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
