package factorymodel;

/**
 * @author jing
 * @create 2020-04-16-14:27
 */
public class BJPeeperPizza extends pizza {
    @Override
    public void prepare() {
        setName("北京胡椒pizza");
        System.out.println(name + "准备原材料");
    }
}
