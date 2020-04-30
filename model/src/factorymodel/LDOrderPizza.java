package factorymodel;

/**
 * @author jing
 * @create 2020-04-16-14:55
 */
public class LDOrderPizza implements AbsFactory{
    @Override
    public pizza creatPizza(String orderType) {
        if (orderType.equals("cheese")){
            return new LDCheesePizza();
        } else if (orderType.equals("peeper")){
            return new LDPeeperPizza();
        } else {
            return null;
        }
    }
}
