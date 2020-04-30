package adapter;

/**
 * @author jing
 * @create 2020-04-17-11:14
 */
public class user {
    public static void main(String[] args) {
        Phone phone = new Phone();
        VoltageAdapter adapter = new VoltageAdapter(new Voltage220V());
        phone.charging(adapter);
    }
}
