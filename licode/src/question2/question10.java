package question2;

import java.util.Stack;

public class question10 {
    public static void main(String[] args) {
        String s="Let's take LeetCode contest";
        String c = "";
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<chars.length;i++){
            stack.push(chars[i]);
        }
        while (!stack.isEmpty()){
            char pop = stack.pop();
            c= c+String.valueOf(pop);
        }
        Stack<String> stack2 = new Stack<>();
        String[] words = c.split(" ");
        for (int j = 0;j<words.length;j++){
            stack2.push(words[j]);
        }
        String re = "";
        while (!stack2.isEmpty()){
            String pop = stack2.pop();
            re = re+" "+pop;
        }
        re = re.trim();
        System.out.println(re);
    }
}
