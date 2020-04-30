package question1;

import com.sun.deploy.panel.ITreeNode;
import jdk.internal.util.xml.impl.ReaderUTF16;

import java.beans.IntrospectionException;
import java.util.HashMap;
import java.util.Stack;

public class question2 {
    public static void main(String[] args) {
//        给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
//        字符（'a' - 'i'）分别用（'1' - '9'）表示。
//        字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
//        返回映射之后形成的新字符串。
//        题目数据保证映射始终唯一。
//(char)(97+i)
        String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        String re = "";
        char r1 = '\0', r2 = '\0', r3 = '\0';
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c:chars){
            stack.push(c);
        }
        int size = stack.size();
        while (!stack.isEmpty()){
            r1 = stack.pop();
            if (r1=='#'){
                r2 = stack.pop();
                r3 = stack.pop();
                re = String.valueOf((char)(Integer.parseInt(String.valueOf(r3) + String.valueOf(r2)) + 96))+re;
            } else {
                re = String.valueOf((char) (Integer.parseInt(String.valueOf(r1)) + 96))+re;
            }
        }
        System.out.println(re);
    }
}
