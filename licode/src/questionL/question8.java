package questionL;

public class question8 {
    public static void main(String[] args) {
//        给你一个仅由数字 6 和 9 组成的正整数 num。
//        你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
//        请返回你可以得到的最大数字。
//        输入：num = 9669
//        输出：9969 Integer.valueOf(String.valueOf(num).replaceFirst("6","9"));
        int num= 9996;
        int a=num;
        int re = 0;
        int n = 0;
        int mod=0;
        int mov=0;
        while (num!=0){
            num=num/10;
            n++;
        }
        int pow = (int)Math.pow(10, n-1);
        for (int i=0;i<n;i++) {
            mod = a % pow;
            mov = a / pow;
            if (mov<10){
                if(mov==9){
                    pow = pow / 10;
                } else {
                    re = 9*pow+mod;
                    break;
                }
            } else {
                mov = a / pow % 10;
                if (mov==9){
                    pow = pow / 10;
                } else {
                    re = a + 3 * pow;
                    break;
                }
            }
        }
        System.out.println(re);
    }
}
