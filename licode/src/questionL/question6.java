package questionL;

public class question6 {
    public static void main(String[] args) {
//        在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
//        给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
//        返回可以通过分割得到的平衡字符串的最大数量。
//        输入：s = "RLRRLLRLRL" 输出：4
//        解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
        String s = "RLRRRLLRLL";
        int count=0;
        int sum=0;
        char[] chars = s.toCharArray();
        for (int i=0;i<s.length();i++){
            if (chars[i]=='R'){
                count++;
            }else {
                count--;
            }
            if (count==0) {
                sum++;
            }
        }
        System.out.println(sum);












//        int num = 1;
//        int i = 0;
//        int sum = 0;
//        char[] chars = s.toCharArray();
//        while (i!=s.length()){
//            if (chars[i]==chars[i+1]){
//                num++;
//                i++;
//            }
//            else {
//                sum++;
//                i = i + num + 1;
//                num=1;
//            }
//        }
//        System.out.println(sum);
    }
}
