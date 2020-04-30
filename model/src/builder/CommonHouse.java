package builder;

/**
 * @author jing
 * @create 2020-04-16-17:59
 */
public class CommonHouse extends HouseBuilder {
    @Override
    public void buildBaise() {
        System.out.println("普通房子地基5m");
    }

    @Override
    public void buildWall() {
        System.out.println("普通房子墙5cm");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子木屋顶");
    }
}
