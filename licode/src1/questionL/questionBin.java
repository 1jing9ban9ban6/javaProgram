package questionL;

/**
 * @author jing
 * @create 2020-03-24-10:57
 */
public class questionBin {
    public static void main(String[] args) {
//        System.out.println(01011);
        hammingWeight(00000000000000000000000000001011);
    }
    public static int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res = res+ (n & 1);
            n >>>= 1;
        }
        return res;
    }
}
