package factorymodel;

/**
 * @author jing
 * @create 2020-04-16-14:28
 */
public class LDPeeperPizza extends pizza {
    @Override
    public void prepare() {
        setName("伦敦胡椒pizza");
        System.out.println(name + "准备原材料");
    }
}
