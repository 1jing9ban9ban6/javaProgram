package questionL;

import java.util.ArrayList;

/**
 * @author jing
 * @create 2020-03-26-11:47
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class questionArray {
    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralOrder(ints);
    }
    public static void spiralOrder(int[][] matrix) {
        int i = matrix[0].length;
        int j = matrix.length-1;
        ArrayList<Integer> list = new ArrayList<>();
        int x=0, y=0, m=0, n=0;
        for (; i >= 0 && j >= 0 ;) {
            for (int k = 0;k < i; k++, y++) {
                list.add(matrix[x][y]);
            }
            m = x+1;
            n=y-1;
            for (int k = 0; k < j;k++, m++) {
                list.add(matrix[m][n]);
            }
            x=m-1;
            y=n-1;
            i--;
            j--;
            for (int k = 0; k < i; k++, y--) {
                list.add(matrix[x][y]);
            }
            m=x-1;
            n=y+1;
            for (int k = 0; k < j; k++, m--) {
                list.add(matrix[m][n]);
            }
            x=m+1;
            y=n+1;
            i--;
            j--;
        }
        int [] re = new int[matrix.length*matrix[0].length];
        for (int k = 0; k < re.length; k++) {
            re[k] = list.get(k);
        }
    }
}
