package leeCode;

import javax.tools.ForwardingFileObject;
import java.util.*;

/**
 * @author jing
 * @create 2020-04-12-16:01
 */
public class hand1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String math = in.next();
        char[] chars = math.toCharArray();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if ("(".equals(String.valueOf(chars[i])) || ")".equals(String.valueOf(chars[i]))){
                queue.offer(String.valueOf(chars[i]));
            }
        }
        int right = 0;
        int wrong_r = 0;
        int wrong_l = 0;
        Stack<String> stack = new Stack<>();
        while (!queue.isEmpty()){
            String s = queue.poll();
            if ("(".equals(s)){
                stack.push(s);
            } else {
                if (!stack.isEmpty()){
                    String pop = stack.pop();
                    right = right + 1;
                } else {
                    wrong_r = wrong_r + 1;
                }
            }
        }
        while (!stack.isEmpty()){
            stack.pop();
            wrong_l = wrong_l + 1;
        }
        System.out.println(right+" "+wrong_l+" "+wrong_r);
    }
}
