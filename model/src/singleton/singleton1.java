package singleton;


/**
 * @author jing
 * @create 2020-04-16-11:20
 * 饿汉式（静态常量）
 * 1.构造器私有化（防止在外面new对象）
 * 2.类的内部创建对象
 * 3.向外部暴露一个获取实例的getInstance()方法
 * 饿汉式会造成资源浪费。但没有多线程问题。
 * jdk runtime 类用到了这个饿汉式
 */
public class singleton1 {
    public static void main(String[] args) {
        singletonTest1 instance = singletonTest1.getInstance();
    }
}

class singletonTest1 {
    //    1.构造器私有化
    private singletonTest1() {
    }

    //    2.类的内部创建对象
    private final static singletonTest1 instance = new singletonTest1();

    //    3.向外部暴露一个获取实例的getInstance()方法
    public static singletonTest1 getInstance() {
        return instance;
    }
}
