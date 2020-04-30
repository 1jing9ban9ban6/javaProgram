package factorymodel;

/**
 * @author jing
 * @create 2020-04-16-14:39
 */
public class BJOrderPizza implements AbsFactory {
    @Override
    public pizza creatPizza(String orderType) {
        if (orderType.equals("cheese")){
            return new BJCheesePizza();
        } else if (orderType.equals("peeper")){
            return new BJPeeperPizza();
        } else {
            return null;
        }
    }
}
