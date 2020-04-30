package singleton;

/**
 * @author jing
 * @create 2020-04-16-11:30
 * 懒汉式线程不安全
 */
public class singleton3 {
    public static void main(String[] args) {
        singletonTest3 instance = singletonTest3.getInstance();
        singletonTest3 instance1 = singletonTest3.getInstance();
        System.out.println(instance == instance1);
    }
}

class singletonTest3 {
    //    创建一个静态变量
    private static singletonTest3 instance;

    //    私有化构造器
    private singletonTest3() {
    }

    //    提供获取实例方法
    public static singletonTest3 getInstance() {
        if (instance == null) {
            instance = new singletonTest3();
        }
        return instance;
    }
}
