package question1;

public class question {
    public static void main(String[] args) {
        //    给你一个整数 n，请你返回 任意 一个由 n 个
        //    各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
        int n = 6;
        int num = -n/2;
        int [] list = new int[n];
        for (int i = 0; i<(list.length>>1); i++){
            list[i]=num;
            list[list.length-1-i]=0-num;
            num++;
        }
    }
}
