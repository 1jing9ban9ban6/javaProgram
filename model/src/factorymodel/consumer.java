package factorymodel;

/**
 * @author jing
 * @create 2020-04-16-14:58
 */
public class consumer {
    public static void main(String[] args) {
        new OrderPizza(new BJOrderPizza());
    }
}
