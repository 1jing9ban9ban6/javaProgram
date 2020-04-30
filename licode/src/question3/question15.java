package question3;

/**
 * @author jing
 * @create 2020-03-21-9:34
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class question15 {
    public static void main(String[] args) {
        System.out.println(numWays(7));
    }

    public static int numWays(int n) {
        int temp = 0;
        long re = 0;
        int len = n / 2 + 1;
        for (int i = 0; i < len; i++) {
            temp = n + i;
            if (i == 0) {
                re = re + 1;
            } else if (i == 1) {
                re = re + temp;
            } else {
                re = re + doFactorial(temp - i + 1, temp) / doFactorial(1, i);
            }
            n = n - 2;
        }
        return (int) (re % 1000000007);
    }

    public static long doFactorial(int x, int y) {
        long re = 1;
        for (int i = x; i <= y; i++) {
            re = re * i;
        }
        return re;
    }
}
