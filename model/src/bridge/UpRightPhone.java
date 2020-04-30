package bridge;

/**
 * @author jing
 * @create 2020-04-18-10:23
 */
public class UpRightPhone extends Phone{
    public UpRightPhone(Brand brand) {
        super(brand);
    }
    public void open(){
        super.open();
        System.out.println("直立样式手机");
    }
    public void call(){
        super.call();
        System.out.println("直立样式手机");
    }
    public void close(){
        super.close();
        System.out.println("直立样式手机");
    }
}
