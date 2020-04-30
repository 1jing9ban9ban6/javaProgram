package factorymodel;

/**
 * @author jing
 * @create 2020-04-16-14:29
 */
public class LDCheesePizza extends pizza {
    @Override
    public void prepare() {
        setName("伦敦奶酪pizza");
        System.out.println(name + "准备原材料");
    }
}
