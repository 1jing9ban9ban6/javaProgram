package question2;

import java.util.ArrayList;

public class question6 {
    public static void main(String[] args) {
//        给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
//        输入：[-4,-1,0,3,10]
//        输出：[0,1,9,16,100]
        int[] nums = {-4, -1, 0, 3, 10};
        int[] re = new int[nums.length];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<nums.length;i++){
            list.add((int)Math.pow(nums[i],2));
        }
        list.sort(Integer::compareTo);
        for (int j=0;j<re.length;j++){
            re[j]=list.get(j);
        }
    }
}
