package question3;

/**
 * @author jing
 * @create 2020-03-21-9:06
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 */
public class question14 {
    public static void main(String[] args) {
        System.out.println(fib(48));
    }

    public static int fib(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        }
        int temp0 = 0, temp1 = 1;
        int re = 0;
        for (int i = 1; i < n; i++) {
            re = (temp0 + temp1) % 1000000007;
            temp0 = temp1;
            temp1 = re;
        }
        return re;
    }
}
