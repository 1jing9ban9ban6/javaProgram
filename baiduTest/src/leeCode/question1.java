package leeCode;

import java.util.Stack;

/**
 * @author jing
 * @create 2020-03-30-21:48
 */
public class question1 {
    public static void main(String[] args) {
        question1 question1 = new question1();
        question1.push(512);
        question1.push(-1024);
        question1.push(-1024);
        question1.push(512);
        question1.pop();
        System.out.println(question1.min());
        question1.pop();
        System.out.println(question1.min());
        question1.pop();
        System.out.println(question1.min());
    }
    Stack<Integer> stack;
    Stack<Integer> help;

    public question1() {
        stack = new Stack<>();
        help = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            help.push(x);
        } else {
            if (help.peek() >= x) {
                help.push(x);
                stack.push(x);
            } else {
                stack.push(x);
            }
        }
    }

    public void pop() {
        if (stack.peek().equals(help.peek())){
            stack.pop();
            help.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return help.peek();
    }
}
