package bridge;

/**
 * @author jing
 * @create 2020-04-18-10:16
 */
public class user {
    public static void main(String[] args) {
        FoldedPhone phone = new FoldedPhone(new XiaoMi());
        phone.call();
    }
}
