package singleton;

/**
 * @author jing
 * @create 2020-04-16-11:30
 * 懒汉式（加同步代码块）但线程不安全
 */
public class singleton4 {
    public static void main(String[] args) {
        singletonTest4 instance = singletonTest4.getInstance();
        singletonTest4 instance1 = singletonTest4.getInstance();
        System.out.println(instance == instance1);
    }
}

class singletonTest4 {
//    创建一个静态变量
    private static singletonTest4 instance;
//    私有化构造器
    private singletonTest4() {
    }
//    提供获取实例方法
    public static singletonTest4 getInstance() {
        if (instance == null){
            synchronized (singletonTest4.class){
                instance = new singletonTest4();
            }
        }
        return instance;
    }
}
