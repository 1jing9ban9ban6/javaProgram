package leeCode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author jing
 * @create 2020-04-12-16:59
 */
public class hand3 {
    public static void main(String[] args) {
        int[] a = new int[]{8, 9, 7};
        int[] b = new int[]{5, 8, 3};
        hand3 hand3 = new hand3();
        int[] ints = hand3.WaitInLine(a, b);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
    public int[] WaitInLine (int[] a, int[] b) {
        LinkedList<ArrayList<Integer>> list = new LinkedList<>();
        int[] re = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(a[i]);
            arrayList.add(b[i]);
            arrayList.add(i+1);
            list.add(arrayList);
        }
        int j = 1;
        while (!list.isEmpty()){
            int[] temp = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ArrayList<Integer> list1 = list.get(i);
                int num = list1.get(0) * (j-1) + list1.get(1) * (a.length - j);
                temp[i] = num;
            }
            int min = 0;
            for (int k = 0; k < temp.length; k++){
                if (temp[k] < temp[min]){
                    min =  k;
                }
            }
            re[j-1] = list.get(min).get(2);
            list.remove(min);
            j++;
        }
        return re;
    }
}
