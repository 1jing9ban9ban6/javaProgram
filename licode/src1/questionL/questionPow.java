package questionL;

/**
 * @author jing
 * @create 2020-03-24-11:15
 */
public class questionPow {
    public static void main(String[] args) {
        double v = myPow(2.10000, 3);
        System.out.println(v);
    }
    public static double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        long b = n;
        double re = x * x;
        long m = b >> 1;
        for (int i = 1; i < m; i++) {
            re = re *x*x;
        }
        if ((n&1)==0){
            return re;
        } else {
            return re*x;
        }
    }
}
