package adapter;

/**
 * @author jing
 * @create 2020-04-17-11:13
 */
public class Phone {
    public void charging(Voltage5V voltage5V){
        int v = voltage5V.output5V();
        if (v == 5){
            System.out.println("手机正在充电");
        } else {
            System.out.println("电压不合适 无法充电");
        }
    }
}
