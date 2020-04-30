package singleton;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author jing
 * @create 2020-04-16-11:30
 * 静态内部类线程安全
 */
public class singleton6 {
    public static void main(String[] args) {
        singletonTest6 instance = singletonTest6.getInstance();
        singletonTest6 instance1 = singletonTest6.getInstance();
        System.out.println(instance == instance1);
    }
}

class singletonTest6 {
    //    构造器私有化
    private singletonTest6() {
    }

    //    创建静态内部类new对象 静态内部类只有该外部的类加载的时候才会首先加载多线程进来之后调用方法之前先加载一次
    private static class SingletonInstance {
        private static final singletonTest6 instance = new singletonTest6();
    }

    public static singletonTest6 getInstance() {
        return SingletonInstance.instance;
    }
}
