package fanxing;

/**
 * @author jing
 * @create 2020-02-27-20:36
 */
public class test1 {
    public static void main(String[] args) {
        fanXingTest<Boolean> test = new fanXingTest<>();
        test.setDesc(true);
//        test.setDesc("哈哈哈哈");
//        System.out.println(test.getDesc());
        fanZi fanZi = new fanZi();
//        Integer[] ints = new Integer[]{};
        Integer copy = fanZi.copy(new Integer[]{});
    }
}
