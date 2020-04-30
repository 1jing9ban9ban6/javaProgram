package leeCode;

import java.util.*;

/**
 * @author jing
 * @create 2020-04-02-19:08
 */
public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int len = sc.nextInt();
//        int num = sc.nextInt();
//        ArrayList<Integer> list = new ArrayList(len);
//        for (int i = 0; i < list.size(); i++) {
//            list.add(sc.nextInt());
//        }
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        int num = 2;
        System.out.println(computer(list, num));
    }

    public static int computer(List<Integer> list, int num) {
        int flag1, flag2, t = 0;
        while (list.get(maxArr(list)) - list.get(minArr(list)) > num) {
            int maxIndex = maxArr(list);
            int minIndex = minArr(list);
            // 最大值 最小值
            Integer max = list.get(maxIndex);
            Integer min = list.get(minIndex);
            list.remove(maxIndex);
            int maxIndexTwo = maxArr(list);
            Integer maxTwo = list.get(maxIndexTwo);
            flag1 = maxTwo - min;
            list.add(max); // 加回来

            // 最小值
            list.remove(minIndex);
            int minIndexTwo = minArr(list);
            Integer minTwo = list.get(minIndexTwo);
            flag2 = max - minTwo;
            list.add(min); // 加回来
            if (flag1 < flag2) {
                list.remove(max);
                t = t + 1;
            } else {
                list.remove(min);
                t = t + 1;
            }
        }
        return t;
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

    private static int maxArr(List<Integer> list) {
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > list.get(index)){
                index = i;
            }
        }
        return index;
    }
}
