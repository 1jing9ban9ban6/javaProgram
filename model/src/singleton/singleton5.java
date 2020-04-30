package singleton;

/**
 * @author jing
 * @create 2020-04-16-11:30
 * 懒汉式（双端检索加volatile）线程安全
 */
public class singleton5 {
    public static void main(String[] args) {
        singletonTest5 instance = singletonTest5.getInstance();
        singletonTest5 instance1 = singletonTest5.getInstance();
        System.out.println(instance == instance1);
    }
}

class singletonTest5 {
    //    创建一个静态变量
    private volatile static singletonTest5 instance;

    //    私有化构造器
    private singletonTest5() {
    }

    //    提供获取实例方法
    public static singletonTest5 getInstance() {
        if (instance == null) {
            synchronized (singletonTest5.class) {
                if (instance == null) {
                    instance = new singletonTest5();
                }
            }
        }
        return instance;
    }
}
