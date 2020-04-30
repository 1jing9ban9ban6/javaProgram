package factorymodel;

/**
 * @author jing
 * @create 2020-04-16-14:25
 */
public class BJCheesePizza extends pizza {
    @Override
    public void prepare() {
        setName("北京奶酪pizza");
        System.out.println(name + " 准备原材料");
    }
}
