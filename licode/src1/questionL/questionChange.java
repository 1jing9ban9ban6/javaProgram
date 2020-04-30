package questionL;

import java.util.Arrays;

/**
 * @author jing
 * @create 2020-03-25-11:40
 */
public class questionChange {
    public static void main(String[] args) {
        int[] exchange = exchange(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(exchange));
    }
    public static int[] exchange(int[] nums) {
        if (nums.length==0){
            return nums;
        }
        int i = 0, j = nums.length-1;
        int temp = 0;
        while (i != j){
            if ((nums[i]&1)==0 && (nums[j]&1)==1){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else if ((nums[i]&1) == 1){
                i++;
            } else {
                j--;
            }
        }
        return nums;
    }
}
