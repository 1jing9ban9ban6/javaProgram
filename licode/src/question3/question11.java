package question3;

/**
 * @author jing
 * @create 2020-03-19-22:47
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class question11 {
    public static void main(String[] args) {
        long i = test(120);
        System.out.println(i);
    }

    public static long test(int n) {
        if ((n + 2) % 3 == 0) {
            return (int) (Math.pow(3.0, (n - 4) / 3) * 4) % 1000000007;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n % 3 == 0) {
            long i = (long) (Math.pow(3.0, (n) / 3));
            long r = i % 1000000007;
            return  r;
//            return (int) (Math.pow(3.0, (n) / 3)) % 1000000007;
        } else {
            return (int) (Math.pow(3.0, (n) / 3) * 2) % 1000000007;
        }
    }
}
