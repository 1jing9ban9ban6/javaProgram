package builder;

/**
 * @author jing
 * @create 2020-04-16-17:56
 */
public abstract class HouseBuilder {
    House house = new House();
    public abstract void buildBaise();
    public abstract void buildWall();
    public abstract void roofed();
    public House buildHouse(){
        return house;
    }
}
