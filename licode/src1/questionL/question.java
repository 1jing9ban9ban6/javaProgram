package questionL;

/**
 * @author jing
 * @create 2020-03-22-8:58
 */
public class question {
    public static void main(String[] args) {
        int[] ints = {3,1,1};
        System.out.println(minArray(ints));
    }
    public static int minArray(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i]<numbers[i-1]){
                return numbers[i];
            }
        }
        if (numbers.length==2){
            return numbers[0]>numbers[1]? numbers[1]:numbers[0];
        }
        return numbers[0];
    }
}
