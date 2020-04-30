package adapter;

/**
 * @author jing
 * @create 2020-04-17-11:11
 */
public class VoltageAdapter implements Voltage5V {
    Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int i = voltage220V.output220V();
        return i / 44;
    }
}
