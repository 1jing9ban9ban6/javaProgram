package questionL;

public class question1 {
    public static void main(String[] args) {
        // 将数字变成 0 的操作次数
        // 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。
        // 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
        int step = 0;
        int num = 14;
        while (num!=0){
            if((num&1)==1){
                num--;
                step++;
            } else {
                num = num>>1;
                step++;
            }
        }
        System.out.println(step);
    }
}

