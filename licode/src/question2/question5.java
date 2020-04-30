package question2;

import jdk.nashorn.internal.objects.NativeReferenceError;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class question5 {
    //    给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
    //    返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
    //    如果 S[i] == "I"，那么 A[i] < A[i+1]
    //    如果 S[i] == "D"，那么 A[i] > A[i+1]
    //    输出："IDID"
    //    输出：[0,4,1,3,2]
    public static void main(String[] args) {
        String S ="DDI";
        char[] chars = S.toCharArray();
        int max = S.length();
        int min = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i= 0;i<S.length();i++){
            if (chars[i]=='D'){
                list.add(max);
                max--;
            } else {
                list.add(min);
                min++;
            }
        }
        list.add(max);
        int[] nums = new int[list.size()];
        for (int j=0;j<list.size();j++){
            nums[j] = list.get(j);
        }
    }
}