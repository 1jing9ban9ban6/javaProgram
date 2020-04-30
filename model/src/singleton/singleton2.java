package singleton;

/**
 * @author jing
 * @create 2020-04-16-11:30
 * 静态代码块的饿汉式
 */
public class singleton2 {
    public static void main(String[] args) {
        singletonTest2 instance = singletonTest2.getInstance();
        singletonTest2 instance1 = singletonTest2.getInstance();
        System.out.println(instance == instance1);
    }
}

class singletonTest2 {
    //    1.构造器私有化
    private singletonTest2() {
    }

    //    2.类的内部创建对象
    private static singletonTest2 instance;

    //    3.在静态代码块中完成初始化
    static {
        instance = new singletonTest2();
    }

    //    4.向外部暴露一个获取实例的getInstance()方法
    public static singletonTest2 getInstance() {
        return instance;
    }
}
