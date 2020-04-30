package question3;

import java.util.ArrayList;

public class question {
    public static void main(String[] args) {
//        找出数组中重复的数字。
//        在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
//        数组中某些数字是重复的，但不知道有几个数字重复了，
//        也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。        Arrays.sort(nums);
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        for (int i = 0; i < nums.length; i++) {
            while (i!=nums[i]){
                if (nums[nums[i]]!=nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                } else {
                    System.out.println(nums[i]);
                }
            }
        }
    }
}
