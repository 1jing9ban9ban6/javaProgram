package builder;

/**
 * @author jing
 * @create 2020-04-16-18:03
 */
public class user {
    public static void main(String[] args) {
        CommonHouse commonHouse = new CommonHouse();
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        House gai = houseDirector.gai();
    }
}
