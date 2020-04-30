package question4;

public interface usb {
    void start();
    void end();

    public static void hello() {
        System.out.println("jj");
    };
    public default void bay(){
        System.out.println("nn");
    };
}
