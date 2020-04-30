package question2;

import java.util.ArrayList;

public class question8 {
    public static void main(String[] args) {
//        给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
        int[] nums = new int[]{1,4,3,2};
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0;j<nums.length;j++){
            list.add(nums[j]);
        }
        list.sort(Integer::compareTo);
        for ( int i=0;i<list.size()/2;i++){
            sum = sum+list.get(2*i);
        }
        System.out.println(sum);
    }
}
