package singleton;


/**
 * @author jing
 * @create 2020-04-16-11:20
 * 懒汉式用同步方法
 *
 */
public class singleton8 {
    public static void main(String[] args) {
        singletonTest8 instance = singletonTest8.getInstance();
    }
}

class singletonTest8 {
    //    1.构造器私有化
    private singletonTest8() {
    }

    //    2.类的内部创建对象
    private static singletonTest8 instance;

    //    3.向外部暴露一个获取实例的getInstance()方法
    public static synchronized singletonTest8 getInstance() {
        if (instance==null){
            instance = new singletonTest8();
        }
        return instance;
    }
}
