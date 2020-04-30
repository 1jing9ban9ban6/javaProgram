/**
 * @author jing
 * @create 2020-03-21-17:01
 */
public class singleDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{Car.getCar();}).start();
        }
    }
}
class Car{
    private static volatile Car car = null;
    private Car(){
        System.out.println(Thread.currentThread().getName());
    }
    public static Car getCar(){
        if (car == null){
            synchronized (Car.class){
                if (car == null){
                    car = new Car();
                }
            }
        }
        return car;
    }
}
