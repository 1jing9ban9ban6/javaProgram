package paixu;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jing
 * @create 2020-02-25-14:52
 */
public class stringCompare {
    public static void main(String[] args) {
        String[] s = new String[]{"AA","DD","EE","BB","GG","MM","ZZ"};
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(s));
    }
}
