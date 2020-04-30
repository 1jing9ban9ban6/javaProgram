package question3;

/**
 * @author jing
 * @create 2020-03-20-9:41
 *求 1+2+...+n ，要求不能使用乘除法、for、while、if、
 * else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class question12 {
    public static void main(String[] args) {

    }
    public static int sumNums(int n) {
        return n == 1 ? 1 : n + sumNums(n - 1);
    }
}
