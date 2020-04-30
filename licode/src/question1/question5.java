package question1;

import org.omg.CORBA.IRObject;
import sun.print.SunMinMaxPage;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Stack;

public class question5 {
    //    自除数 是指可以被它包含的每一位数除尽的数。
//    例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
//    还有，自除数不允许包含 0 。
//    给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数
//    输入：
//    上边界left = 1, 下边界right = 22
//    输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
    public static void main(String[] args) {
        int left = 1, right = 22;
        ArrayList<Integer> re = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int mod,mov,j,size = 1;
        for (int i = left; i <= right; i++) {
            j = i;
            do {
                mod = j%10;// yu
                if (mod ==0){
                    stack.clear();
                    break;
                }
                mov = j/10; // chu
                stack.push(mod);
                j = j / 10;
            } while (mov!=0);
            size = stack.size();
            while (!stack.isEmpty()){
                if(i%stack.pop()==0){
                    size--;
                }
                if (size==0){
                    re.add(i);
                }
            }
        }
        System.out.println(re);
    }
}
