package learn;

/**
 * @author jing
 * @create 2020-04-27-17:57
 */
public class test2 {
    public static void main(String[] args) {
        for (int i = 2; i < 101; i++) {
            int num = 0;
            for (int j = 1; j <=i; j++) {
                if (i%j==0){
                    num++;
                }
            }
            if (num==2){
                System.out.println(i);
            }
        }
    }
}
