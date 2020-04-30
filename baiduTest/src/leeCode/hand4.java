package leeCode;

import java.util.concurrent.CountDownLatch;

/**
 * @author jing
 * @create 2020-04-12-17:38
 */
public class hand4 {
    public static void main(String[] args) {

    }
    public int GetMaxStaffs (char[][] pos) {
        int count = 0;
        for (int i = 0; i < pos.length; i++) {
            for (int j = 0; j < pos[0].length; j++) {
                if (".".equals(String.valueOf(pos[i][j]))){
                    count++;
                }
            }
        }
        boolean[] flag = new boolean[count];
        int num = 0;
        for (int i = 0; i < pos.length; i++) {
            for (int j = 0; j < pos[0].length; j++) {
                if (".".equals(String.valueOf(pos[i][j]))){
                    if (j-1>=0 && ".".equals(String.valueOf(pos[i][j-1]))){
                        System.out.println(8);
                    }
                }
            }
        }
        return num;
    }
}
