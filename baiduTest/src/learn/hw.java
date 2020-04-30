package learn;


import java.util.*;

/**
 * @author jing
 * @create 2020-04-22-19:01
 */
public class hw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]>47 && chars[i]<58){
                int num = Integer.parseInt(String.valueOf(chars[i]));
                list.add(num);
            }
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
}
