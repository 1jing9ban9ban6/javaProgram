package question2;

import java.util.ArrayList;
import java.util.function.IntPredicate;

public class question9 {
    public static void main(String[] args) {
//        我们把符合下列属性的数组 A 称作山脉：
//        A.length >= 3
//        存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
//        给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
//        输入：[0,1,0]
//        输出：1
        int[] A = new int[]{0,2,1,0};
        int index = 0;
        int max = 0;
        for (int i =0;i<A.length;i++) {
            if (max<A[i]){
                max = A[i];
                index = i;
            }
        }
        System.out.println(index);
    }
}
