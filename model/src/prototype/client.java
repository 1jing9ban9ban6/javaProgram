package prototype;


/**
 * @author jing
 * @create 2020-04-16-15:52
 * 实现两种深拷贝
 */
public class client {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("a", 1, "n");
        DeepPerson deepPerson = new DeepPerson("张三", "123", sheep);
//        一种是重写object的clone方法，另一种用序列化来实现
//        DeepPerson clone = deepPerson.clone();
        DeepPerson clone = deepPerson.deepClone();
        System.out.println(clone);
        System.out.println(clone.getSheep()==sheep);
    }
}
