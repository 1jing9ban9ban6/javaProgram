package question3;

import java.util.Stack;

/**
 * @author jing
 * @create 2020-03-20-20:54
 */
public class question13 {
    Stack<Integer> sIn;
    Stack<Integer> sOut;
    public question13() {
        sIn = new Stack<>();
        sOut = new Stack<>();
    }

    public void appendTail(int value) {
        while (!sOut.isEmpty()){
            sIn.push(sOut.pop());
        }
        sIn.push(value);
    }

    public int deleteHead() {
        while (!sIn.isEmpty()){
            sOut.push(sIn.pop());
        }
        if (sOut.isEmpty()){
            return -1;
        } else {
            return sOut.pop();
        }
    }
}
