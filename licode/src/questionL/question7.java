package questionL;


public class question7 {
    public static void main(String[] args) {
//        给你一个以行程长度编码压缩的整数列表 nums 。
//        考虑每对相邻的两个元素 [a, b] = [nums[2*i], nums[2*i+1]] 
//        （其中 i >= 0 ），每一对都表示解压后有 a 个值为 b 的元素。请你返回解压后的列表。
//        输入：nums = [1,2,3,4]
//        输出：[2,4,4,4]
//        解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
//        第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
//        最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
        int[] nums= new int[]{1,3,4,8,9,7,9,4,5,2};
        int[] tempA = new int[nums.length>>1];
        int[] tempB = new int[nums.length>>1];
        int total = 0;
        for (int i = 0; i < nums.length>>1; i++){
            total = nums[2*i] + total;
            tempA[i] = nums[2*i+1];
            tempB[i] = nums[2*i];
        }
        int [] re = new int[total];
        int sum = 0;
        for (int i = 0; i < nums.length>>1; i++){
           for (int j = 0; j < tempB[i]; j++){
               re[sum+j]=tempA[i];
           }
           sum = sum + tempB[i];
        }
    }
}
