package leeCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author jing
 * @create 2020-04-02-20:15
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int num = sc.nextInt();
        int sum = 0;
        int temp = 0;
        ArrayList<Integer> list = new ArrayList<>(len);
        System.out.println(list.size());
        for (int i = 0; i < len; i++) {
            temp = sc.nextInt();
            list.add(temp);
            System.out.println(sum+" "+temp);
            sum = sum + temp;
        }
        System.out.println(sum);
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(2);
//        list.add(1);
//        list.add(4);
//        list.add(3);
//        System.out.println(computer(list, num, sum));
    }
    public static int computer(List<Integer> list, int num, int sum){
        int lun = num / sum;
        int re = lun * list.size();
        int mov = num % sum;
        while (list.get(minArr(list)) <= mov){
            for (int i = 0; i < list.size(); i++) {
                if (mov >= list.get(i)){
                    mov = mov - list.get(i);
                    re = re + 1;
                }
            }
        }
        return re;
    }
    private static int minArr(List<Integer> list) {
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < list.get(index)){
                index = i;
            }
        }
        return index;
    }
}
