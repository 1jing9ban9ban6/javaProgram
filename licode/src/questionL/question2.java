package questionL;

public class question2 {
    public static void main(String[] args) {
//        给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
//        输入：n = 234
//        输出：15
//        解释：
//        各位数之积 = 2 * 3 * 4 = 24
//        各位数之和 = 2 + 3 + 4 = 9
//        结果 = 24 - 9 = 15
        int n = 234;
        int resultSum=0,resultMup=1;
        while(n!=0) //判断所要进行查询的数是不是为0
        {
            resultSum+=n%10;
            resultMup*=n%10;
            n/=10;
        }
        System.out.println(resultMup-resultSum);

    }
}
