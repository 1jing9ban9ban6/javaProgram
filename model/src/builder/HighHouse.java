package builder;

/**
 * @author jing
 * @create 2020-04-16-18:00
 */
public class HighHouse extends HouseBuilder {
    @Override
    public void buildBaise() {
        System.out.println("高楼地基10m");
    }

    @Override
    public void buildWall() {
        System.out.println("高楼墙10cm");
    }

    @Override
    public void roofed() {
        System.out.println("高楼屋顶透明的");
    }
}
