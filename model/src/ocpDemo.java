/**
 * @author jing
 * @create 2020-04-15-17:33
 */
public class ocpDemo {
    public static void main(String[] args) {
        tool tool = new tool();
        tool.drew(new sanjiao());
    }
}
abstract class shape{
    public abstract void drew();
}
class tool{
    public void drew(shape shape){
        shape.drew();
    }
}
class sanjiao extends shape{
    @Override
    public void drew() {
        System.out.println("画个三角形");
    }
}
class sibian extends shape{
    @Override
    public void drew() {
        System.out.println("画个四边形");
    }
}
