package questionL;

public class question3 {
    public static void main(String[] args) {
//        给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
//        输入：nums = [12,345,2,6,7896]
//        输出：2
        int[] nums = new int[]{12,345,2,6,7896};
        int count = 0; //计数
        int re = 0;
        for (int i =0;i<nums.length;i++){
            while(nums[i]>=1) {
                nums[i]/=10;
                count++;
            }
            if (count%2==0){
                re = re + 1;
            }
            count = 0;
        }
    }
}
