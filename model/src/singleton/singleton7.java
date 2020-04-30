package singleton;

/**
 * @author jing
 * @create 2020-04-16-11:30
 * 静态内部类线程安全
 */
public class singleton7 {
    public static void main(String[] args) {
        singletonTest7 instance = singletonTest7.INSTANCE;
        singletonTest7 instance1 = singletonTest7.INSTANCE;
        System.out.println(instance == instance1);
    }
}

enum singletonTest7{
    INSTANCE;
}
