package question3;

import java.util.HashMap;

public class question1 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(nums[i]) == null) {
                hashMap.put(nums[i], nums[i]);
            } else {
                System.out.println(nums[i]);
            }
        }
    }
}
