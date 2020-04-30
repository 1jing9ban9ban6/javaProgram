package question1;

import java.util.Arrays;
import java.util.Properties;

public class question4 {
//    学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
//    请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
//    输入：heights = [1,1,4,2,1,3] 输出：3
    public static void main(String[] args) {
        int [] heights = new int[]{1,1,4,2,1,3};
        int [] re = heights.clone();
        int peo = 0;
        Arrays.sort(heights);
        for(int i=0;i<heights.length;i++){
            if (heights[i]!=re[i]){
                peo++;
            }
        }
        System.out.println(peo);
    }
}
