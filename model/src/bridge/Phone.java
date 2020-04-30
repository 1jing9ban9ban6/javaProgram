package bridge;

/**
 * @author jing
 * @create 2020-04-18-10:14
 */
public abstract class Phone {
    Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }
    protected void open(){
        brand.open();
    }
    protected void call(){
        brand.call();
    }
    protected void close(){
        brand.close();
    }
}
