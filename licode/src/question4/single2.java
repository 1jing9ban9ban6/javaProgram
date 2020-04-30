package question4;


public class single2 {
    public static void main(String[] args) {
    }
}
class phone{
    private phone(){}
    private static phone instance = null;

    public static phone instance() {
        if(instance==null){
            synchronized (phone.class){
                if (instance==null){
                    instance = new phone();
                }
            }
        }
        return instance;
    }
//    {
//        System.out.println("随着 对象 的创建就会执行");
//    }
//    static {
//        System.out.println("随着 类 的加载就会执行");
//    }
}
