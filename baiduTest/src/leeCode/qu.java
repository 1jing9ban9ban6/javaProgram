package leeCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jing
 * @create 2020-04-07-20:40
 */
public class qu {
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        s1.add(2);
        s1.add(0);
        s1.add(3);
        s2.add(3);
        s2.add(0);
        s2.add(1);
        s2.add(2);
        int peo = 0;
        if (s1.contains(0)){
            peo = peo + s1.size();
        }
    }

}
